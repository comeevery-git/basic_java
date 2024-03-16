package app.application.vo.member;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import app.domain.model.entity.member.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Schema(description = "회원 수정 응답 정보")
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UpdateMemberVo {

    @Schema(description = "회원 고유 아이디", example = "2312310001")
    private Long memberId;

    @Schema(description = "최종 수정일", example = "2021-07-01T00:00:00")
    private LocalDateTime updatedDate;

    public static UpdateMemberVo toVo(Member member) {
        return UpdateMemberVo.builder()
                .memberId(member.getMemberId())
                .updatedDate(member.getUpdatedDate())
                .build();
    }

}