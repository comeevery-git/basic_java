package app.auth.domain.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import app.auth.domain.model.entity.Wallet;
import app.auth.domain.repository.WalletRepository;
import app.member.domain.model.entity.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VerificationService { // TODO WalletService
	private final WalletRepository walletRepository; // TODO 구현체는 Infrastructure 에 작성

	@Async
	public void addWalletAccountAsync() {
		this.createWallet();

		/*
		 * TODO 지갑 잔액이 추가되는 비즈니스 로직
		 */
		this.addAmount("WALLET0001", BigDecimal.valueOf(1000000));
	}

	private void createWallet() {
		Wallet wallet = new Wallet();
		wallet.setWalletId("WALLET0001");
		wallet.setWalletName("WALLET_NAME");
		wallet.setAmount(BigDecimal.ZERO);
		wallet.setMemberId("MEMBER0001");
		wallet.setCreatedDate(LocalDateTime.now());
		wallet.setCreatedMemberId("MEMBER0001");
		walletRepository.save(wallet);
	}

	private void addAmount(String walletId, BigDecimal amount) {
		Wallet wallet = walletRepository.findByWalletId(walletId).orElseThrow(() -> new RuntimeException("지갑 정보가 없습니다."));
		wallet.setAmount(wallet.getAmount().add(amount));
		walletRepository.save(wallet);
	}

}

