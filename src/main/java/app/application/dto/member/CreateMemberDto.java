package app.application.dto.member;

import app.domain.model.entity.member.Role;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
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
public class CreateMemberDto {
    @NotBlank
    @Schema(description = "회원 이름", example = "김동동", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotBlank
    @Schema(description = "회원 이메일", example = "example@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @Enumerated(EnumType.STRING)
    @NotBlank
    @Schema(description = "회원 권한", example = "MEMBER", implementation = Role.class, requiredMode = Schema.RequiredMode.REQUIRED)
    private Role role;

}