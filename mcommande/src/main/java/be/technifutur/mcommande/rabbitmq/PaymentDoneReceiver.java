package be.technifutur.mcommande.rabbitmq;

import be.technifutur.mcommande.services.OrderService;
import be.technifutur.mcommande.utils.OrderNotFoundException;
import be.technifutur.mcommande.utils.PaidOrder;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "paymentDoneQueue")
public class PaymentDoneReceiver {

    @Autowired
    private OrderService orderService;

    @RabbitHandler
    public void receive(String in) throws OrderNotFoundException {
        Gson gson = new Gson();
        PaidOrder paidOrder = gson.fromJson(in, PaidOrder.class);
        orderService.updatePaymentFlag(paidOrder.getOrderId());
        System.out.println("[x] Receive [ Payement Done for Order '"+ paidOrder.getOrderId() +"']");
    }


}
