package be.technifutur.mcommande.repositories;


import be.technifutur.mcommande.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUserId(int id);
}
