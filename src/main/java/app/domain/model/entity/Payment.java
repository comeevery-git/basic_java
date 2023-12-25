package app.domain.model.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="payment")
public class Payment {
    @Id
    @Column(name = "payment_id", nullable = false)
    private String paymentId;

    @Column(name = "pay_method", nullable = false, length = 100)
    private String payMethod;

    @Column(name = "imp_u_id", nullable = false, length = 100)
    private String impUid;

    @Column(name = "merchant_u_id", nullable = false, length = 100)
    private String merchantUid;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "created_member_id", nullable = false)
    private String createdMemberId;
}