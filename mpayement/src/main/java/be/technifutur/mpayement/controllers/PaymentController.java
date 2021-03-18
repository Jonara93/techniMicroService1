package be.technifutur.mpayement.controllers;

import be.technifutur.mpayement.dtos.PaymentDto;
import be.technifutur.mpayement.entities.Payment;
import be.technifutur.mpayement.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentDto> payOrder(@RequestBody Payment payment) throws Exception {
        return ResponseEntity.status(201).body(paymentService.payOrder(payment));
    }

}
