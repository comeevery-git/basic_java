package app.member.application.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import app.member.domain.model.entity.Member;
import app.member.domain.model.entity.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;

@Schema(description = "회원 응답 정보")
@Builder
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MemberVo {
    @Schema(description = "회원 고유 아이디", example = "2312310001")
    private Long memberId;

    @Schema(description = "회원 이름", example = "김동동")
    private String name;

    @Email
    @Schema(description = "회원 이메일", example = "example@gmail.com")
    private String email;

    @Enumerated(EnumType.STRING)
    @Schema(description = "회원 권한", example = "MEMBER")
    private Role role;

    @Schema(description = "최초 생성일", example = "2021-07-01T00:00:00")
    private LocalDateTime createdDate;

    @Schema(description = "최초 생성 회원 아이디", example = "2021-07-01T00:00:00")
    private Long createdMemberId;

    @Schema(description = "최종 수정일", example = "2021-07-01T00:00:00")
    private LocalDateTime updatedDate;

    @Schema(description = "최종 수정 회원 아이디", example = "2312310001")
    private Long updatedMemberId;


    public static MemberVo toVo(Member member) {
        return MemberVo.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .email(member.getEmail())
                .role(member.getRole())
                .build();
    }
}