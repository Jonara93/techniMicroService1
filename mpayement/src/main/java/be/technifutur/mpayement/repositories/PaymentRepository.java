package be.technifutur.mpayement.repositories;

import be.technifutur.mpayement.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findByOrderId(int id);
}
