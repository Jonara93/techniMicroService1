package be.technifutur.mlivraison.controllers;

import be.technifutur.mlivraison.dtos.DeliveryDto;
import be.technifutur.mlivraison.entities.Delivery;
import be.technifutur.mlivraison.services.DeliveryService;
import be.technifutur.mlivraison.utils.DeliveryNotFoundException;
import be.technifutur.mlivraison.utils.ExistingDeliveryException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin
@RequestMapping("/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping()
    public List<DeliveryDto> getAll() {
        return this.deliveryService.getAllDelivery();
    }

    @GetMapping("/{id}")
    public DeliveryDto getById(@PathVariable int id) throws DeliveryNotFoundException {
        return this.deliveryService.getById(id);
    }

    @PostMapping()
    public void getAll(@RequestBody Delivery delivery) throws JsonProcessingException, ExistingDeliveryException {
        this.deliveryService.insertDelivery(delivery);
    }

}

