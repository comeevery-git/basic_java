package app.payment.application.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import app.payment.domain.model.entity.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;

@Schema(description = "결제수단 응답 정보")
@Builder
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaymentVo {

    @Schema(description = "결제수단 고유 아이디", example = "2312310001")
    private Long paymentId;

    @Schema(description = "회원 고유 아이디", example = "2312310001")
    private String memberId;

    @Enumerated(EnumType.STRING)
    @Schema(description = "결제수단 상태", example = "A", implementation = Status.class)
    private Status status;

}