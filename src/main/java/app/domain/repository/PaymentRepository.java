package app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.domain.model.entity.payment.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}