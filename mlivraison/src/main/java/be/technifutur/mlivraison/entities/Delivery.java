package be.technifutur.mlivraison.entities;

import be.technifutur.mlivraison.utils.DeliverySupplier;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    LocalDate creationDate;

    LocalDate estimatedDeliveryDate;

    @Enumerated(EnumType.STRING)
    DeliverySupplier deliverySupplier;

    int deliveryprice;

    int orderId;
}
