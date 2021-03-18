package be.technifutur.mUser.mapper;

import be.technifutur.mUser.dtos.UserDto;
import be.technifutur.mUser.entities.User;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    public UserDto toUserDto(User user) {
        return user != null ? UserDto.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .pseudo(user.getPseudo())
                .email(user.getEmail())
                .password(user.getPassword())
                .billingAddress(user.getBillingAddress())
                .deliveryAddress(user.getDeliveryAddress())
                .build() : null;
    }

    public User toUserEntity(UserDto user) {
        return user != null ? User.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .pseudo(user.getPseudo())
                .email(user.getEmail())
                .password(user.getPassword())
                .billingAddress(user.getBillingAddress())
                .deliveryAddress(user.getDeliveryAddress())
                .build() : null;
    }
}
