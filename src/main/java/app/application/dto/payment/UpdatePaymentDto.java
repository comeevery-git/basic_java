package app.application.dto.payment;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import app.domain.model.entity.payment.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "결제수단 수정 요청 정보")
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UpdatePaymentDto {

    @Schema(description = "결제수단 고유 아이디", example = "2312310001")
    private Long paymentId;

    @Schema(description = "회원 고유 아이디", example = "2312310001")
    private Long memberId;

    @Schema(description = "수정 할 결제수단", example = "신용카드", maxLength = 10)
    private String paymentMethod;

    @Schema(description = "수정 할 결제수단 번호", example = "신용카드 번호", maxLength = 50)
    private String paymentMethodNumber;

    @Schema(description = "수정 할 결제수단 상태 (A: 활성화, I: 비활성화, P:승인대기, D: 삭제)", example = "I", implementation = Status.class)
    private Status status;

}