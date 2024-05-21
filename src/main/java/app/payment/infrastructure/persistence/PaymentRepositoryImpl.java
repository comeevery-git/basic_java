package app.payment.infrastructure.persistence;


import com.querydsl.jpa.impl.JPAQueryFactory;

import app.payment.domain.repository.custom.CustomPaymentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentRepositoryImpl implements CustomPaymentRepository {
    private final JPAQueryFactory query;

}