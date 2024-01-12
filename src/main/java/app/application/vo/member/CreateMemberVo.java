package app.application.vo.member;

import app.domain.model.enums.Role;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;

@Schema(description = "회원 정보")
@Builder
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateMemberVo {

    @Schema(description = "회원 고유 아이디", example = "M2312310001")
    private String memberId;

    @Schema(description = "회원 이름", example = "김동동")
    private String name;

    @Email
    @Schema(description = "회원 이메일", example = "example@gmail.com")
    private String email;

    @Enumerated(EnumType.STRING)
    @Schema(description = "회원 권한", example = "MEMBER")
    private Role role;

    @Schema(description = "최초 생성일", example = "2021-07-01T00:00:00")
    private String createdDate;

    @Schema(description = "최초 생성 회원 아이디", example = "2021-07-01T00:00:00")
    private String createdMemberId;
}