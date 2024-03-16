package app.domain.service.payment;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.application.dto.payment.CreatePaymentDto;
import app.application.dto.payment.UpdatePaymentDto;
import app.application.vo.payment.CreatePaymentVo;
import app.application.vo.payment.UpdatePaymentVo;
import app.domain.model.common.ResponseCode;
import app.domain.model.entity.payment.Payment;
import app.domain.repository.PaymentRepository;
import app.infrastructure.exception.CustomException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Transactional
    public CreatePaymentVo createPayment(CreatePaymentDto dto) {
        try {
            Payment payment = Payment.builder()
                            .memberId(dto.getMemberId())
                            .paymentMethod(dto.getPaymentMethod())
                            .paymentMethodNumber(dto.getPaymentMethodNumber())
                            .createdMemberId(dto.getMemberId())
                            .build();
            Payment result = paymentRepository.save(payment);
            log.info("### 결제수단 생성 결과: {}", result);

            return CreatePaymentVo.toVo(result);
        } catch (DataIntegrityViolationException e) {
            throw new CustomException(ResponseCode.CONFLICT_DATA);
        } catch (CustomException e) {
            throw new CustomException(e.getResponseCode());
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    public UpdatePaymentVo updatePayment(UpdatePaymentDto dto) {
        try {
            Payment payment = paymentRepository.findById(dto.getPaymentId()).orElseThrow(() -> new CustomException(ResponseCode.NOT_EXIST));
            log.info("### 결제수단 조회 결과: {}", payment);

            if (!dto.getPaymentMethod().isBlank()) {
                payment.setPaymentMethod(dto.getPaymentMethod());
            }
            if (!dto.getPaymentMethodNumber().isBlank()) {
                payment.setPaymentMethodNumber(dto.getPaymentMethodNumber());
            }
            if (!dto.getStatus().equals(payment.getStatus())) {
                payment.setStatus(dto.getStatus());
            }
            payment.setUpdatedMemberId(dto.getMemberId());

            Payment result = paymentRepository.save(payment);
            log.info("### 결제수단 수정 결과: {}", result);

            return UpdatePaymentVo.toVo(payment);
        } catch (DataIntegrityViolationException e) {
            throw new CustomException(ResponseCode.CONFLICT_DATA);
        } catch (CustomException e) {
            throw new CustomException(e.getResponseCode());
        } catch (Exception e) {
            throw e;
        }
    }

}
