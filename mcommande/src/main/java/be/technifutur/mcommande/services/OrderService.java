package be.technifutur.mcommande.services;

import be.technifutur.mcommande.dtos.OrderDto;
import be.technifutur.mcommande.entities.Order;
import be.technifutur.mcommande.mapper.Mapper;
import be.technifutur.mcommande.repositories.OrderRepository;
import be.technifutur.mcommande.utils.OrderNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final Mapper mapper;
    private final OrderRepository orderRepository;

    public OrderService(Mapper mapper, OrderRepository orderRepository) {
        this.mapper = mapper;
        this.orderRepository = orderRepository;
    }

    public List<OrderDto> getAllOrder() {
        return orderRepository.findAll()
                .stream().map(mapper::toOrderDto)
                .collect(Collectors.toList())
                ;
    }

    public OrderDto getOrderById(int id) throws OrderNotFoundException {
        Optional<Order> order = this.orderRepository.findById(id);
        if (order.isEmpty())
            throw new OrderNotFoundException("La commande d'id " + id + "n'a pas été trouvée !");

        return order.isPresent() ? mapper.toOrderDto(order.get()) : null;
    }

    public List<OrderDto> getAllOrderByUserId(int id) {
        return this.orderRepository.findByUserId(id)
                .stream()
                .map(this.mapper::toOrderDto)
                .collect(Collectors.toList())
                ;
    }

    public OrderDto insertOrder(Order order) {
        if (order != null) {
            order = orderRepository.save(order);
            return mapper.toOrderDto(order);
        }
        return null;
    }

    public void updateOrder(Order order) throws OrderNotFoundException {
        if (order != null) {
            this.orderRepository.save(order);
        } else {
            throw new OrderNotFoundException("Order pas là");
        }
    }

    public void updatePaymentFlag(int id) throws OrderNotFoundException {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) throw new OrderNotFoundException("Pas trouvé frère");
        order.get().setIsPaid(true);
        orderRepository.save(order.get());
    }

    public void updateDeliveryCompanyName(int id, String deliveryName) throws OrderNotFoundException {
        Order orderToUpdate = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("pas trouvé"));
        orderToUpdate.setDeliveryCompany(deliveryName);
        this.orderRepository.save(orderToUpdate);
    }
}
