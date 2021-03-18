package be.technifutur.mcommande.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue paymentDoneQueue() {
        return new Queue("paymentDoneQueue");
    }

    @Bean
    Queue deliveryDoneQueue() {
        return new Queue("deliveryDoneQueue");
    }

    @Bean
    public PaymentDoneReceiver paymentDoneSender() {
        return new PaymentDoneReceiver();
    }

    @Bean
    public DeliveryDoneReceiver deliveryDoneReceiver() {
        return new DeliveryDoneReceiver();

    }
}
