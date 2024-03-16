package app.application.dto.payment;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import app.domain.model.entity.payment.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "회원 생성 요청 정보")
@Setter
@Getter
@ToString
@EqualsAndHashCode
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreatePaymentDto {

    @Schema(description = "회원 고유 아이디", example = "2312310001")
    private Long memberId;

    @Schema(description = "결제수단", example = "계좌이체", maxLength = 10)
    private String paymentMethod;

    @Schema(description = "결제수단 번호", example = "계좌번호", maxLength = 50)
    private String paymentMethodNumber;

    @Schema(description = "결제수단 상태", example = "A", implementation = Status.class, hidden = true)
    private Status status = Status.ACTIVE;

}