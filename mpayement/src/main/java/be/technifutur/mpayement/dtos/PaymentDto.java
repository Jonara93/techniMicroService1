package be.technifutur.mpayement.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PaymentDto {
    Integer id;
    Integer orderId;
    Integer amount;
    String cardNumber;
}
