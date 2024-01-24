package app.domain.repository;

import app.domain.model.entity.member.Member;
import app.domain.repository.custom.CustomMemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, CustomMemberRepository {

}