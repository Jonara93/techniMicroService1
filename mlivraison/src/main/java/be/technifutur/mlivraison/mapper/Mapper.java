package be.technifutur.mlivraison.mapper;

import be.technifutur.mlivraison.dtos.DeliveryDto;
import be.technifutur.mlivraison.entities.Delivery;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    public DeliveryDto toDeliveryDto(Delivery delivery) {
        return DeliveryDto.builder()
                .id(delivery.getId())
                .deliverySupplier(delivery.getDeliverySupplier())
                .estimatedDeliveryDate(delivery.getEstimatedDeliveryDate())
                .deliveryprice(delivery.getDeliveryprice())
                .creationDate(delivery.getCreationDate())
                .orderId(delivery.getOrderId())
                .build();
    }

    public Delivery toDeliveryEntity(DeliveryDto delivery) {
        return Delivery.builder()
                .id(delivery.getId())
                .deliverySupplier(delivery.getDeliverySupplier())
                .estimatedDeliveryDate(delivery.getEstimatedDeliveryDate())
                .deliveryprice(delivery.getDeliveryprice())
                .creationDate(delivery.getCreationDate())
                .orderId(delivery.getOrderId())
                .build();
    }
}
