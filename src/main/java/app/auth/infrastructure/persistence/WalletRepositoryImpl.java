package app.auth.infrastructure.persistence;

import java.util.Optional;

import com.querydsl.jpa.impl.JPAQueryFactory;

import app.auth.domain.model.entity.QWallet;
import app.auth.domain.model.entity.Wallet;
import app.auth.domain.repository.custom.CustomWalletRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WalletRepositoryImpl implements CustomWalletRepository {
    private final JPAQueryFactory query;
    private QWallet qWallet = QWallet.wallet;

    @Override
    public Optional<Wallet> findByWalletId(String walletId) {
        return Optional.ofNullable(query
			.selectFrom(qWallet)
			.where(
				qWallet.walletId.eq(walletId)
			)
			.fetchOne());
    }

}