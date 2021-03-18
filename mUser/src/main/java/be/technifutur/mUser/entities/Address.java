package be.technifutur.mUser.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {
    String street;
    String number;
    String zip;
    String city;
    String country;
}
