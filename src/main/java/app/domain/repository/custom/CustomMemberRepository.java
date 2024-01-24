package app.domain.repository.custom;

import app.domain.model.entity.member.Member;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomMemberRepository {
    Member findByEmail(String email);


}