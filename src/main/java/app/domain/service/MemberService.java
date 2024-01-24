package app.domain.service;

import app.application.dto.member.CreateMemberDto;
import app.application.vo.member.CreateMemberVo;
import app.application.vo.member.MemberVo;
import app.domain.model.common.ResponseCode;
import app.domain.model.entity.member.Member;
import app.domain.repository.MemberRepository;
import app.infrastructure.exception.CustomException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public CreateMemberVo createMember(CreateMemberDto dto) {
        try {
            Member member = Member.builder()
                            .name(dto.getName())
                            .email(dto.getEmail())
                            .role(dto.getRole())
                            .build();
            Member result = memberRepository.save(member);
            log.info("### 회원 생성 결과: {}", result);

            return CreateMemberVo.toVo(result);
        } catch (DataIntegrityViolationException e) {
            throw new CustomException(ResponseCode.CONFLICT_DATA);
        } catch (CustomException e) {
            throw new CustomException(e.getResponseCode());
        } catch (Exception e) {
            throw e;
        }
    }

    public MemberVo getMember(Long memberId) {
        try {
            Member member = memberRepository.findById(memberId).orElseThrow(() -> new CustomException(ResponseCode.NOT_EXIST));
            log.info("### 회원 조회 결과: {}", member);
            return MemberVo.toVo(member);
        } catch (CustomException e) {
            throw new CustomException(e.getResponseCode());
        } catch (Exception e) {
            throw e;
        }

    }
}
