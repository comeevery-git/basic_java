package app.member.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.member.domain.model.entity.Member;
import app.member.domain.repository.custom.CustomMemberRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, CustomMemberRepository {

}