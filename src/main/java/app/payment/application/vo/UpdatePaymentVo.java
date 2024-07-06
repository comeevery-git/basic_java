package app.payment.application.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import app.payment.domain.model.entity.Payment;
import app.payment.domain.model.entity.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Schema(description = "결제수단 수정 응답 정보")
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UpdatePaymentVo {

    @Schema(description = "회원 고유 아이디", example = "2312310001")
    private Long memberId;

    @Schema(description = "결제수단 고유 아이디", example = "2312310001")
    private Long paymentId;

    @Enumerated(EnumType.STRING)
    @Schema(description = "결제수단 상태", example = "I", implementation = Status.class)
    private Status status;

    @Schema(description = "최종 수정일", example = "2021-07-01T00:00:00")
    private LocalDateTime updatedDate;

    public static UpdatePaymentVo toVo(Payment payment) {
        return UpdatePaymentVo.builder()
                .paymentId(payment.getPaymentId())
                .memberId(payment.getMemberId())
                .status(payment.getStatus())
                .updatedDate(payment.getUpdatedDate())
                .build();
    }
}