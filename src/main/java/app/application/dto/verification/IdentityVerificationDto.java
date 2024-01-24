package app.application.dto.verification;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "신원 조회 요청 정보")
@Setter
@Getter
@ToString
@EqualsAndHashCode
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class IdentityVerificationDto {
    @NotBlank
    @Schema(description = "회원 이름", example = "김동동", required = true)
    private String name;
}