package be.technifutur.mcommande.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "mOrder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    Integer productId;

    @CreationTimestamp
    Instant orderDate;

    Integer productQuantity;

    Boolean isPaid;

    String deliveryCompany;

    int userId;

}
