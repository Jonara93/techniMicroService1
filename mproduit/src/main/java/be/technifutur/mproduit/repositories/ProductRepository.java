package be.technifutur.mproduit.repositories;

import be.technifutur.mproduit.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
