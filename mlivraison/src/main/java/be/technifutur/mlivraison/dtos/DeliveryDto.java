package be.technifutur.mlivraison.dtos;

import be.technifutur.mlivraison.utils.DeliverySupplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryDto {
    int id;
    LocalDate creationDate;
    LocalDate estimatedDeliveryDate;
    DeliverySupplier deliverySupplier;
    int deliveryprice;
    int orderId;
}
