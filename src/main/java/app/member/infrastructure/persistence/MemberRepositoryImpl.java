package app.member.infrastructure.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;

import app.member.domain.model.entity.Member;
import app.member.domain.model.entity.QMember;
import app.member.domain.repository.custom.CustomMemberRepository;
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