package app.domain.model.entity;

import app.domain.model.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Schema(description = "회원 정보 Entity")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="member", uniqueConstraints = {
        @UniqueConstraint(name = "NAME_EMAIL_UNIQUE", columnNames = {"name", "email"})
    }
)
public class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "member_id", nullable = false)
    @Schema(description = "회원 고유 아이디", example = "2312310001")
    private Long memberId;

    @Column(name = "name", nullable = false, length = 10)
    @Schema(description = "회원 이름", example = "김동동")
    private String name;

    @Column(name = "email", nullable = false)
    @Schema(description = "회원 이메일", example = "example@gmail.com")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    @Schema(description = "회원 권한", example = "MEMBER")
    private Role role;

    @Column(name = "created_date", nullable = false)
    @Schema(description = "최초 생성일", example = "2021-07-01T00:00:00")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "created_member_id", nullable = false)
    @Schema(description = "최초 생성 회원 아이디", example = "2021-07-01T00:00:00")
    private Long createdMemberId;

    @Column(name = "updated_date")
    @Schema(description = "최종 수정일", example = "2021-07-01T00:00:00")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "updated_member_id")
    @Schema(description = "최종 수정 회원 아이디", example = "2312310001")
    private Long updatedMemberId;
}