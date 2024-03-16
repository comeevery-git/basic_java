package app.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.application.dto.member.CreateMemberDto;
import app.application.vo.member.CreateMemberVo;
import app.application.vo.member.MemberVo;
import app.domain.model.common.BaseResponse;
import app.domain.service.member.MemberService;
import app.infrastructure.annotation.CommonResponseCode;
import app.infrastructure.exception.CustomException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Member", description = "회원 정보 관련 API")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/{memberId}")
    @Operation(summary = "회원 정보 조회", description = "회원 정보를 조회합니다.")
    @CommonResponseCode
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
    @CommonResponseCode
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
