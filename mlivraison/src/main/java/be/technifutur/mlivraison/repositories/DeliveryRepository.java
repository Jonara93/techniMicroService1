package be.technifutur.mlivraison.repositories;

import be.technifutur.mlivraison.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    Delivery findByOrderId(int orderId);
}
