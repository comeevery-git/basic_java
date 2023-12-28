package app.presentation;

import app.application.dto.member.CreateMemberDto;
import app.application.vo.member.CreateMemberVo;
import app.domain.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public CreateMemberVo createMember(CreateMemberDto createMemberDto) {
        log.info("createMemberDto: {}", createMemberDto);

        memberService.createMember(createMemberDto);
        return null;
    }


}
