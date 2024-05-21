package app.auth.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.auth.domain.model.entity.Wallet;
import app.auth.domain.repository.custom.CustomWalletRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long>, CustomWalletRepository {

}