package app.application.dto.member;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import app.domain.model.entity.member.Role;
import app.domain.model.entity.payment.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "회원 수정 요청 정보")
@Setter
@Getter
@ToString
@EqualsAndHashCode
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UpdateMemberDto {

    @NotBlank
    @Schema(description = "회원 고유 아이디", example = "2312310001", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long memberId;

    @Schema(description = "수정 할 회원 이름", example = "김동동", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String name;

    @Schema(description = "수정 할 회원 이메일", example = "example@gmail.com", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String email;

    @Schema(description = "수정 할 회원 상태 (A: 활성화, I: 비활성화, D: 삭제)", example = "I", implementation = Status.class)
    private Status status;

    @Schema(description = "수정 할 회원 권한", example = "MEMBER", implementation = Role.class, requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Role role;

}