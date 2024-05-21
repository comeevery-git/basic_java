package app.auth.domain.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import app.member.domain.model.entity.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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

    @Column(name = "member_id", nullable = false)
    private String memberId;
    // @ManyToOne
    // @JoinColumn(name = "memberId", nullable = false)
    // private Member member;

    @Column(name = "created_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "created_member_id")
    private String createdMemberId;

    @Column(name = "updated_date")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "updated_member_id")
    private String updatedMemberId;
}