package be.technifutur.mUser.utils;

import be.technifutur.mUser.entities.Address;
import be.technifutur.mUser.entities.User;
import be.technifutur.mUser.services.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataInit implements InitializingBean {

    private final UserService userService;

    public DataInit(UserService userService) {
        this.userService = userService;
    }

    private List<User> users = Arrays.asList(
            User.builder()
                    .firstname("Jonathan")
                    .lastname("Arabia")
                    .pseudo("Wizounet")
                    .email("wiz@hot.be")
                    .password("1234")
                    .deliveryAddress(
                            Address.builder()
                                    .city("Outsiplou")
                                    .country("Belgique")
                                    .number("42")
                                    .street("Rue du Roy")
                                    .zip("4242")
                                    .build()
                    )
                    .billingAddress(
                            Address.builder()
                                    .city("Outsiplou")
                                    .country("Belgique")
                                    .number("42")
                                    .street("Rue du Roy")
                                    .zip("4242")
                                    .build()
                    )
                    .build()
    );

    @Override
    public void afterPropertiesSet() throws Exception {
        this.users.forEach(this.userService::insertUser);
    }
}
