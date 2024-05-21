package app.payment.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.payment.domain.model.entity.PaymentHistory;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {

}