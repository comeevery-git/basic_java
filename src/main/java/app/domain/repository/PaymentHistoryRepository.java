package app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.domain.model.entity.payment.PaymentHistory;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {

}