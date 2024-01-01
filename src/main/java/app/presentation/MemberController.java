package app.presentation;

import app.application.dto.member.CreateMemberDto;
import app.application.vo.member.CreateMemberVo;
import app.domain.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService memberService;

    /**
     * 회원 등록
     * @param createMemberDto
     * @return
     */
    @PostMapping
    public CreateMemberVo createMember(@RequestBody CreateMemberDto createMemberDto) {
        log.info("createMemberDto: {}", createMemberDto);

        return memberService.createMember(createMemberDto);
    }


}
