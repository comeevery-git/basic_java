package app.domain.service.payment;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.domain.model.entity.payment.Payment;
import app.domain.model.entity.payment.PaymentHistory;
import app.domain.repository.PaymentHistoryRepository;
import app.infrastructure.exception.CustomException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class PaymentHistoryService {
    private final PaymentHistoryRepository paymentHistoryRepository;

    /**
     * 결제수단 수정 시작 시 결제수단 수정 이력 저장
     * @param payment
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createPaymentHistory(Payment payment) {
        try {
            log.info("### 결제수단 이력 생성 START: {}", payment);
            PaymentHistory paymentHistroy = PaymentHistory.builder().build(); // TODO build
            PaymentHistory result = paymentHistoryRepository.save(paymentHistroy);
            log.info("### 결제수단 이력 생성 END");
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        } catch (CustomException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
