package app.member.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.common.domain.model.common.BaseResponse;
import app.common.infrastructure.annotation.CommonResponseCode;
import app.common.infrastructure.exception.CustomException;
import app.member.application.dto.CreateMemberDto;
import app.member.application.dto.UpdateMemberDto;
import app.member.application.vo.CreateMemberVo;
import app.member.application.vo.MemberVo;
import app.member.application.vo.UpdateMemberVo;
import app.member.domain.service.MemberService;
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

    @GetMapping("/{member_id}")
    @Operation(summary = "회원 정보 조회", description = "회원 정보를 조회합니다.")
    @CommonResponseCode
    public BaseResponse<MemberVo> getMember(@PathVariable(name = "member_id") final Long memberId) {
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

    @PutMapping("/{member_id}")
    @Operation(summary = "회원 정보 수정", description = "회원 정보를 수정합니다.")
    @CommonResponseCode
    public BaseResponse<UpdateMemberVo> updateMember(@PathVariable(name = "member_id") final Long memberId
                                                    , @RequestBody final UpdateMemberDto updateMemberDto) {
        updateMemberDto.setMemberId(memberId);
        log.info("updateMemberDto: {}", updateMemberDto);
        try {
            UpdateMemberVo memberVo = memberService.updateMember(updateMemberDto);
            return BaseResponse.successResponse(memberVo);
        } catch (CustomException e) {
            return BaseResponse.failResponse(e.getResponseCode());
        } catch (Exception e) {
            return BaseResponse.failResponse(e);
        }
    }


}
