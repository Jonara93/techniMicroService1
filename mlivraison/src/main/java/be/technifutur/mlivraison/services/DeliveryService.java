package be.technifutur.mlivraison.services;

import be.technifutur.mlivraison.dtos.DeliveryDto;
import be.technifutur.mlivraison.entities.Delivery;
import be.technifutur.mlivraison.mapper.Mapper;
import be.technifutur.mlivraison.rabbitmq.DeliveryDoneSender;
import be.technifutur.mlivraison.repositories.DeliveryRepository;
import be.technifutur.mlivraison.utils.DeliveryNotFoundException;
import be.technifutur.mlivraison.utils.ExistingDeliveryException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryService {

    private final Mapper mapper;
    private final DeliveryRepository deliveryRepository;
    private final DeliveryDoneSender deliveryDoneSender;

    public DeliveryService(Mapper mapper, DeliveryRepository deliveryRepository, DeliveryDoneSender deliveryDoneSender) {
        this.mapper = mapper;
        this.deliveryRepository = deliveryRepository;
        this.deliveryDoneSender = deliveryDoneSender;
    }

    public List<DeliveryDto> getAllDelivery() {
        return this.deliveryRepository.findAll()
                .stream()
                .map(mapper::toDeliveryDto)
                .collect(Collectors.toList())
                ;
    }

    public DeliveryDto getById(int id) throws DeliveryNotFoundException {

        Delivery delivery = this.deliveryRepository.findById(id).orElseThrow(() -> new DeliveryNotFoundException("Livraison d'id : " + id + " non trouvé"));
        return this.mapper.toDeliveryDto(delivery);
    }

    public void insertDelivery(Delivery delivery) throws JsonProcessingException, ExistingDeliveryException {

        if (this.deliveryRepository.findByOrderId(delivery.getOrderId()) != null)
            throw new ExistingDeliveryException("Mode de livraison déjà choisi");

        delivery.setCreationDate(LocalDate.now());
        delivery.setDeliveryprice(delivery.getDeliverySupplier().getPrice());
        delivery.setEstimatedDeliveryDate(delivery.getCreationDate().plusDays(delivery.getDeliverySupplier().getNbOfDays()));

        this.deliveryDoneSender.send(delivery.getOrderId(), delivery.getDeliverySupplier().name());

        this.deliveryRepository.save(delivery);
    }
}
