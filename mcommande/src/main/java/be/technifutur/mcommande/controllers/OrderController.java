package be.technifutur.mcommande.controllers;

import be.technifutur.mcommande.dtos.OrderDto;
import be.technifutur.mcommande.entities.Order;
import be.technifutur.mcommande.services.OrderService;
import be.technifutur.mcommande.utils.OrderNotFoundException;
import be.technifutur.mcommande.utils.PaidOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> getAllOrder() {
        return this.orderService.getAllOrder();
    }

    @GetMapping(path = "/{id}")
    public OrderDto getOrderById(@PathVariable int id) throws OrderNotFoundException {
        return this.orderService.getOrderById(id);
    }

    @GetMapping(path = "user/{id}")
    public List<OrderDto> getAllOrderByUserId(@PathVariable int id) {
        return this.orderService.getAllOrderByUserId(id);
    }

    @PostMapping
    public ResponseEntity<OrderDto> insertOrder(@RequestBody Order order) {
        return ResponseEntity.status(201).body(orderService.insertOrder(order));
    }

    @PutMapping(path = "/{id}")
    public void updateOrder(@RequestBody Order order) throws OrderNotFoundException {
        this.orderService.updateOrder(order);
    }

    @PostMapping(path = "/paid", consumes = "application/json")
    public void paidOrder(@RequestBody PaidOrder paidOrder) throws OrderNotFoundException {
        this.orderService.updatePaymentFlag(paidOrder.getOrderId());
    }
}
