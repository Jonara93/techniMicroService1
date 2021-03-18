package be.technifutur.mpayement.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class PaymentDoneSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void send(int orderId) throws JsonProcessingException {
        var values = new HashMap<String, Integer>() {{
            put("orderId", orderId);
        }};

        this.template.convertAndSend(queue.getName(), new ObjectMapper().writeValueAsString(values));
        System.out.println(" [x] Sent [ Payement Done for Order '" + orderId + "']");
    }
}
