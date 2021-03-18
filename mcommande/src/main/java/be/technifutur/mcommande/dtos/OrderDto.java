package be.technifutur.mcommande.dtos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {
    Integer id;
    Integer productId;
    Instant orderDate;
    Integer productQuantity;
    String deliveryCompany;
    Boolean isPaid;
    int userId;
}
