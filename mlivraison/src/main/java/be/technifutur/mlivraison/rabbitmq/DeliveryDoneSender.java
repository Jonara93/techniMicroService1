package be.technifutur.mlivraison.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class DeliveryDoneSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void send(int orderId, String deliveryCompany) throws JsonProcessingException {
        var values = new HashMap<String, Object>() {{
            put("orderId", orderId);
            put("deliveryCompany", deliveryCompany);
        }};

        this.template.convertAndSend(queue.getName(), new ObjectMapper().writeValueAsString(values));
        System.out.println(" [x] Sent [ Order #" + orderId + " is Delivery by " + deliveryCompany + " ]");
    }
}
