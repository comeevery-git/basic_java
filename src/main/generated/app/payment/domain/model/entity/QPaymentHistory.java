package app.payment.domain.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPaymentHistory is a Querydsl query type for PaymentHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaymentHistory extends EntityPathBase<PaymentHistory> {

    private static final long serialVersionUID = 1907324127L;

    public static final QPaymentHistory paymentHistory = new QPaymentHistory("paymentHistory");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> createdMemberId = createNumber("createdMemberId", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Long> paymentHistoryId = createNumber("paymentHistoryId", Long.class);

    public final NumberPath<Long> paymentId = createNumber("paymentId", Long.class);

    public final StringPath paymentMethod = createString("paymentMethod");

    public final StringPath paymentMethodNumber = createString("paymentMethodNumber");

    public final EnumPath<Status> status = createEnum("status", Status.class);

    public QPaymentHistory(String variable) {
        super(PaymentHistory.class, forVariable(variable));
    }

    public QPaymentHistory(Path<? extends PaymentHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaymentHistory(PathMetadata metadata) {
        super(PaymentHistory.class, metadata);
    }

}

