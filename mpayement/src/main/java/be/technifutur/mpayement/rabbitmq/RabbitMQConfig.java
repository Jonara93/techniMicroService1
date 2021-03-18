package be.technifutur.mpayement.rabbitmq;

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
    public PaymentDoneSender paymentDoneSender() {
        return new PaymentDoneSender();
    }
}
