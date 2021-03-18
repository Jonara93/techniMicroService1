package be.technifutur.mcommande.rabbitmq;

import be.technifutur.mcommande.services.OrderService;
import be.technifutur.mcommande.utils.OrderDeliveryName;
import be.technifutur.mcommande.utils.OrderNotFoundException;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "deliveryDoneQueue")
public class DeliveryDoneReceiver {

    @Autowired
    private OrderService orderService;

    @RabbitHandler
    public void receive(String in) throws OrderNotFoundException {
        Gson gson = new Gson();
        OrderDeliveryName orderDeliveryName = gson.fromJson(in, OrderDeliveryName.class);
        orderService.updateDeliveryCompanyName(orderDeliveryName.getOrderId(), orderDeliveryName.getDeliveryCompany());
        System.out.println("[x] Receive [ Delivery by " + orderDeliveryName.getDeliveryCompany() + " for Order #" + orderDeliveryName.getOrderId() + "]");
    }


}
