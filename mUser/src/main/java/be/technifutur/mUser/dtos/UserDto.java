package be.technifutur.mUser.dtos;

import be.technifutur.mUser.entities.Address;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    int id;

    String pseudo;

    String password;

    String lastname;

    String firstname;

    String email;

    Address deliveryAddress;

    Address billingAddress;
}
