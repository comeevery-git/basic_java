package app.payment.domain.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.auth.domain.service.VerificationService;
import app.payment.application.dto.CreatePaymentDto;
import app.payment.application.dto.UpdatePaymentDto;
import app.payment.application.vo.CreatePaymentVo;
import app.payment.application.vo.UpdatePaymentVo;
import app.common.domain.model.common.ResponseCode;
import app.payment.domain.model.entity.Payment;
import app.payment.domain.model.entity.Status;
import app.payment.domain.repository.PaymentRepository;
import app.common.infrastructure.exception.CustomException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository; // TODO repository infrastructure 로 이동 - 인터페이스도 ORM 사용하므로 함께 이동 권장
    private final PaymentHistoryService paymentHistoryService;
    private final VerificationService verificationService;

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

            verificationService.addWalletAccountAsync(); // 지갑 잔액 추가 비동기 요청

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
            Payment payment = paymentRepository.findById(dto.getPaymentId()).orElseThrow(() -> new CustomException(
				ResponseCode.NOT_EXIST));
            log.info("### 결제수단 조회 결과: {}", payment);

            // 결제수단 수정 시 이력 저장
            paymentHistoryService.createPaymentHistory(payment);

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

    /**
     * TODO 생성 시 생성 및 수정 일어나도록 테스트
     * @param dto
     * @return
     */
    @Transactional
    public CreatePaymentVo createPaymentAndUpdate(CreatePaymentDto dto) {
        try {
            Payment payment = Payment.builder()
                .memberId(dto.getMemberId())
                .paymentMethod(dto.getPaymentMethod())
                .paymentMethodNumber(dto.getPaymentMethodNumber())
                .createdMemberId(dto.getMemberId())
                .build();
            Payment result = paymentRepository.save(payment);
            log.info("### 결제수단 생성 결과: {}", result);

            UpdatePaymentDto updatePaymentDto = UpdatePaymentDto.builder().status(Status.PENDING).build();
            this.updatePayment(updatePaymentDto);

            return CreatePaymentVo.toVo(result);
        } catch (DataIntegrityViolationException e) {
            throw new CustomException(ResponseCode.CONFLICT_DATA);
        } catch (CustomException e) {
            throw new CustomException(e.getResponseCode());
        } catch (Exception e) {
            throw e;
        }
    }

}
