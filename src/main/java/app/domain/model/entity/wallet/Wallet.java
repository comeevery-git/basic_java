package app.domain.model.entity.wallet;

import app.domain.model.entity.member.Member;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="wallet")
public class Wallet {
    @Id
    @Column(name = "wallet_id", nullable = false)
    private String walletId;

    @Column(name = "wallet_name", nullable = false)
    private String walletName;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "created_member_id")
    private Long createdMemberId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "updated_member_id")
    private Long updatedMemberId;
}