package app.application.vo.payment;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import app.domain.model.entity.payment.Payment;
import app.domain.model.entity.payment.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Schema(description = "결제수단 생성 응답 정보")
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CreatePaymentVo {

    @Schema(description = "회원 고유 아이디", example = "2312310001")
    private Long memberId;

    @Schema(description = "결제수단 고유 아이디", example = "2312310001")
    private Long paymentId;

    @Enumerated(EnumType.STRING)
    @Schema(description = "결제수단 상태", example = "A", implementation = Status.class)
    private Status status;

    @Schema(description = "최초 생성일", example = "2021-07-01T00:00:00")
    private LocalDateTime createdDate;

    public static CreatePaymentVo toVo(Payment payment) {
        return CreatePaymentVo.builder()
                .paymentId(payment.getPaymentId())
                .memberId(payment.getMemberId())
                .status(payment.getStatus())
                .createdDate(payment.getCreatedDate())
                .build();
    }
}