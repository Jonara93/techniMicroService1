package be.technifutur.mUser.repositories;

import be.technifutur.mUser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
