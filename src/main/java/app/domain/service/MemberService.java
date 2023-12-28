package app.domain.service;

import app.application.dto.member.CreateMemberDto;
import app.domain.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public void createMember(CreateMemberDto createMemberDto) {

        memberRepository.save(createMemberDto.toEntity());
    }

}
