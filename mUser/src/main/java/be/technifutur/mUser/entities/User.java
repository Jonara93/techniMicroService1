package be.technifutur.mUser.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "m_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(unique = true)
    String pseudo;

    String password;

    String lastname;

    String firstname;

    @Column(unique = true)
    String email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "street_delivery")),
            @AttributeOverride(name = "number", column = @Column(name = "number_delivery")),
            @AttributeOverride(name = "zip", column = @Column(name = "zip_delivery")),
            @AttributeOverride(name = "city", column = @Column(name = "city_delivery")),
            @AttributeOverride(name = "country", column = @Column(name = "country_delivery"))
    })
    Address deliveryAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "street_billing")),
            @AttributeOverride(name = "number", column = @Column(name = "number_billing")),
            @AttributeOverride(name = "zip", column = @Column(name = "zip_billing")),
            @AttributeOverride(name = "city", column = @Column(name = "city_billing")),
            @AttributeOverride(name = "country", column = @Column(name = "country_billing"))
    })
    Address billingAddress;

}
