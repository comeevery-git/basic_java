package app.domain.model.entity.payment;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "결제수단 정보")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="payment")
public class Payment {
    @Id
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

    @Schema(description = "최종 수정일", example = "2021-07-01T00:00:00")
    @Column(name = "updated_date", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Schema(description = "최종 수정 회원 아이디", example = "2312310001")
    @Column(name = "updated_member_id", nullable = false)
    private Long updatedMemberId;

}