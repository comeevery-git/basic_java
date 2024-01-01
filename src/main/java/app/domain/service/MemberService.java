package app.domain.service;

import app.application.dto.member.CreateMemberDto;
import app.application.vo.member.CreateMemberVo;
import app.domain.model.entity.Member;
import app.domain.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public CreateMemberVo createMember(CreateMemberDto dto) {
        Member member = Member.builder()
                        .name(dto.getName())
                        .email(dto.getEmail())
                        .role(dto.getRole())
                        .build();
        Member result = memberRepository.save(member);
        return CreateMemberVo.toVo(result);

    }

}
