package app.auth.infrastructure.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;

import app.auth.domain.repository.custom.CustomWalletRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WalletRepositoryImpl implements CustomWalletRepository {
    private final JPAQueryFactory query;

}