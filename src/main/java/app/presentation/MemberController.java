package app.presentation;

import app.application.dto.member.CreateMemberDto;
import app.application.vo.member.CreateMemberVo;
import app.application.vo.member.MemberVo;
import app.domain.model.common.BaseResponse;
import app.domain.service.MemberService;
import app.infrastructure.exception.CustomException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Member", description = "회원 정보 관련 API")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/{memberId}")
    @Operation(summary = "회원 정보 조회", description = "회원 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공"
                    , content = @Content(schema = @Schema(implementation = MemberVo.class))),
            @ApiResponse(responseCode = "500", description = "시스템 오류가 발생했습니다."),
    })
    public BaseResponse<MemberVo> getMember(@PathVariable(name = "memberId") final Long memberId) {
        try {
            MemberVo memberVo = memberService.getMember(memberId);
            return BaseResponse.successResponse(memberVo);
        } catch (CustomException e) {
            return BaseResponse.failResponse(e.getResponseCode());
        } catch (Exception e) {
            return BaseResponse.failResponse(e);
        }
    }

    @PostMapping
    @Operation(summary = "회원 정보 등록", description = "회원 정보를 등록합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공"
                    , content = @Content(schema = @Schema(implementation = CreateMemberVo.class))),
            @ApiResponse(responseCode = "500", description = "시스템 오류가 발생했습니다."),
    })
    public BaseResponse<CreateMemberVo> createMember(@RequestBody final CreateMemberDto createMemberDto) {
        log.info("createMemberDto: {}", createMemberDto);
        try {
            CreateMemberVo memberVo = memberService.createMember(createMemberDto);
            return BaseResponse.successResponse(memberVo);
        } catch (CustomException e) {
            return BaseResponse.failResponse(e.getResponseCode());
        } catch (Exception e) {
            return BaseResponse.failResponse(e);
        }
    }


}
