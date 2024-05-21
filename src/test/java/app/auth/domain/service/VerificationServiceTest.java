package app.auth.domain.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;

import app.auth.domain.repository.WalletRepository;

@SpringBootTest
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public class VerificationServiceTest {

	@Autowired
	private VerificationService verificationService;

	@Autowired
	private WalletRepository walletRepository;

	@Test
	@DisplayName("지갑 잔액 추가 메서드 비동기 테스트")
	public void testAddWalletAccountAsync() {
		verificationService.addWalletAccountAsync();

		await().atMost(5, SECONDS).untilAsserted(() -> {
			// 지갑 잔액 추가되었는 지 확인 TODO 잔액 추가 로직 및 테스트 검증 코드 개선
			assertFalse(walletRepository.findAll().isEmpty());
		});
	}
}