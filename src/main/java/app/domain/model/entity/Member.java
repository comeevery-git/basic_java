package app.domain.model.entity;

import app.domain.model.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="member", uniqueConstraints = {
        @UniqueConstraint(name = "NAME_EMAIL_UNIQUE", columnNames = {"name", "email"})
    }
)
public class Member {
    @Id
    @Column(name = "member_id", nullable = false)
    private String memberId;

    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "created_member_id", nullable = false)
    private String createdMemberId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "updated_member_id")
    private String updatedMemberId;
}