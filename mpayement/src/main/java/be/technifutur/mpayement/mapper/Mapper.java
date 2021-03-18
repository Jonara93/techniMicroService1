package be.technifutur.mpayement.mapper;

import be.technifutur.mpayement.dtos.PaymentDto;
import be.technifutur.mpayement.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    public PaymentDto toPayementDto(Payment payment) {
        return payment != null ? PaymentDto.builder()
                .id(payment.getId())
                .orderId(payment.getOrderId())
                .amount(payment.getAmount())
                .cardNumber(payment.getCardNumber())
                .build() : null;
    }

    public Payment toPayementEntity(PaymentDto payementDto) {
        return payementDto != null ? Payment.builder()
                .id(payementDto.getId())
                .orderId(payementDto.getOrderId())
                .amount(payementDto.getAmount())
                .cardNumber(payementDto.getCardNumber())
                .build() : null;
    }
}
