package app.auth.domain.repository.custom;

import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;

import app.auth.domain.model.entity.Wallet;

@NoRepositoryBean
public interface CustomWalletRepository {
	Optional<Wallet> findByWalletId(String walletId);

}