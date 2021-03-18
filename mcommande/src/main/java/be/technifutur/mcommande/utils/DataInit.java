package be.technifutur.mcommande.utils;

import be.technifutur.mcommande.controllers.OrderController;
import be.technifutur.mcommande.entities.Order;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//@Component
public class DataInit implements InitializingBean {

    private final OrderController orderController;

    public DataInit(OrderController orderController) {
        this.orderController = orderController;
    }

    List<Order> orders = Arrays.asList(
            Order.builder()
                    .isPaid(false)
                    .productId(2)
                    .productQuantity(15)
                    .build(),
            Order.builder()
                    .isPaid(false)
                    .productId(1)
                    .productQuantity(18)
                    .build()
    );

    @Override
    public void afterPropertiesSet() throws Exception {
        orders.forEach(orderController::insertOrder);
    }
}
