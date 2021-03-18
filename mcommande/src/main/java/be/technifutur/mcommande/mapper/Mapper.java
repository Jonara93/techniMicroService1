package be.technifutur.mcommande.mapper;

import be.technifutur.mcommande.dtos.OrderDto;
import be.technifutur.mcommande.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public OrderDto toOrderDto(Order order) {
        return order != null ? OrderDto.builder()
                .id(order.getId())
                .productId(order.getProductId())
                .orderDate(order.getOrderDate())
                .productQuantity(order.getProductQuantity())
                .isPaid(order.getIsPaid())
                .deliveryCompany(order.getDeliveryCompany())
                .userId(order.getUserId())
                .build() : null;
    }

    public Order toOrderEntity(OrderDto orderDto) {
        return orderDto != null ? Order.builder()
                .id(orderDto.getId())
                .productId(orderDto.getProductId())
                .orderDate(orderDto.getOrderDate())
                .productQuantity(orderDto.getProductQuantity())
                .isPaid(orderDto.getIsPaid())
                .deliveryCompany(orderDto.getDeliveryCompany())
                .userId(orderDto.getUserId())
                .build() : null;
    }
}
