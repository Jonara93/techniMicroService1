package be.technifutur.mpayement.services;

import be.technifutur.mpayement.dtos.PaymentDto;
import be.technifutur.mpayement.entities.Payment;
import be.technifutur.mpayement.mapper.Mapper;
import be.technifutur.mpayement.rabbitmq.PaymentDoneSender;
import be.technifutur.mpayement.repositories.PaymentRepository;
import be.technifutur.mpayement.utils.ExistingPaymentException;
import be.technifutur.mpayement.utils.ImpossiblePaymentException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final Mapper mapper;
    private final PaymentRepository paymentRepository;
    private final HttpOrderService httpOrderService;
    private final PaymentDoneSender paymentDoneSender;

    public PaymentService(Mapper mapper, PaymentRepository paymentRepository, HttpOrderService httpOrderService, PaymentDoneSender paymentDoneSender) {
        this.mapper = mapper;
        this.paymentRepository = paymentRepository;
        this.httpOrderService = httpOrderService;
        this.paymentDoneSender = paymentDoneSender;
    }

    public PaymentDto payOrder(Payment payment) throws Exception {
        //verif que la commande n'a pas déjà été payé
        Payment existingPayment = this.paymentRepository.findByOrderId(payment.getOrderId());
        if (existingPayment != null)
            throw new ExistingPaymentException("La commande d'id " + payment.getOrderId() + " a déjà été payé");

        //enregistrer le payment
        Payment newPayment = paymentRepository.save(payment);

        if (newPayment == null)
            throw new ImpossiblePaymentException("Erreur, impossible d'établir le payement, veuillez réessayez plus tard :)");

        //Appeler mcommande pour lui signifier que le payement a été effectué
        //VIA CALL API // BACK EN BACK
        //httpOrderService.paidOrderRequest(newPayment.getOrderId());

        //VIA message par RabbitMQ
        paymentDoneSender.send(newPayment.getOrderId());


        return mapper.toPayementDto(newPayment);
    }

}
