package app.infrastructure.persistence;

import app.domain.model.entity.member.Member;
import app.domain.model.entity.member.QMember;
import app.domain.repository.custom.CustomMemberRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements CustomMemberRepository {
    private final JPAQueryFactory query;
    private QMember qMember = QMember.member;

    @Override
    public Member findByEmail(String email) {
        return query
                .selectFrom(qMember)
                .where(
                        qMember.email.eq(email)
                )
                .fetchOne();
    }

}