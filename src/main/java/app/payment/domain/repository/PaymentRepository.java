package app.payment.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.payment.domain.model.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}