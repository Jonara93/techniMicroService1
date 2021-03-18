package be.technifutur.mlivraison.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue deliveryDoneQueue() {
        return new Queue("deliveryDoneQueue");
    }

    @Bean
    public DeliveryDoneSender deliveryDoneSender() {
        return new DeliveryDoneSender();
    }
}
