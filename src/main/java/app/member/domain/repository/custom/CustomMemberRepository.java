package app.member.domain.repository.custom;

import org.springframework.data.repository.NoRepositoryBean;

import app.member.domain.model.entity.Member;

@NoRepositoryBean
public interface CustomMemberRepository {
    Member findByEmail(String email);


}