package app.member.domain.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.member.application.dto.CreateMemberDto;
import app.member.application.dto.UpdateMemberDto;
import app.member.application.vo.CreateMemberVo;
import app.member.application.vo.MemberVo;
import app.member.application.vo.UpdateMemberVo;
import app.common.domain.model.common.ResponseCode;
import app.member.domain.model.entity.Member;
import app.member.domain.repository.MemberRepository;
import app.common.infrastructure.exception.CustomException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
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

    @Transactional(readOnly = true)
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

    @Transactional
    public UpdateMemberVo updateMember(UpdateMemberDto dto) {
        try {
            Member member = memberRepository.findById(dto.getMemberId()).orElseThrow(() -> new CustomException(
				ResponseCode.NOT_EXIST));
            log.info("### 회원 조회 결과: {}", member);

            if (!dto.getName().isBlank()) {
                member.setName(dto.getName());
            }
            if (!dto.getEmail().isBlank()) {
                member.setEmail(dto.getEmail());
            }
            if (!dto.getRole().equals(member.getRole())) {
                member.setRole(dto.getRole());
            }
            member.setUpdatedMemberId(dto.getMemberId());

            Member result = memberRepository.save(member);
            log.info("### 회원 수정 결과: {}", result);

            return UpdateMemberVo.toVo(result);
        } catch (DataIntegrityViolationException e) {
            throw new CustomException(ResponseCode.CONFLICT_DATA);
        } catch (CustomException e) {
            throw new CustomException(e.getResponseCode());
        } catch (Exception e) {
            throw e;
        }
    }


}
