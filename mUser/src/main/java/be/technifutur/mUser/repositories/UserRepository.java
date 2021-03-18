package be.technifutur.mUser.repositories;

import be.technifutur.mUser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByPseudoAndPassword(String pseudo, String password);
}
