package app.application.vo.payment;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import app.domain.model.entity.payment.Status;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "결제수단 상태", example = "A", implementation = Status.class)
    private Status status;

}