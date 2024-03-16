package app.domain.model.entity.payment;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "결제수단 히스토리 정보")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="payment_history")
public class PaymentHistory {
    @Id
    @Schema(description = "결제수단 이력 고유 아이디", example = "2312310001")
    @Column(name = "payment_history_id", nullable = false)
    private Long paymentHistoryId;

    @Schema(description = "결제수단 고유 아이디", example = "2312310001")
    @Column(name = "payment_id", nullable = false)
    private Long paymentId;

    @Schema(description = "결제수단", example = "계좌이체")
    @Column(name = "payment_method", nullable = false, length = 10)
    private String paymentMethod;

    @Schema(description = "결제수단 번호", example = "계좌번호")
    @Column(name = "payment_method_number", nullable = false, length = 50)
    private String paymentMethodNumber;

    @Schema(description = "결제수단 상태", example = "A")
    @Column(name = "status", nullable = false)
    private Status status;

    @Schema(description = "회원 고유 아이디", example = "2312310001")
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Schema(description = "최초 생성일", example = "2021-07-01T00:00:00")
    @Column(name = "created_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Schema(description = "최초 생성 회원 아이디", example = "2021-07-01T00:00:00")
    @Column(name = "created_member_id")
    private Long createdMemberId;

}