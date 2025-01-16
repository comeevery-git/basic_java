package app.auth.domain.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWallet is a Querydsl query type for Wallet
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWallet extends EntityPathBase<Wallet> {

    private static final long serialVersionUID = 1015595662L;

    public static final QWallet wallet = new QWallet("wallet");

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath createdMemberId = createString("createdMemberId");

    public final StringPath memberId = createString("memberId");

    public final DateTimePath<java.time.LocalDateTime> updatedDate = createDateTime("updatedDate", java.time.LocalDateTime.class);

    public final StringPath updatedMemberId = createString("updatedMemberId");

    public final StringPath walletId = createString("walletId");

    public final StringPath walletName = createString("walletName");

    public QWallet(String variable) {
        super(Wallet.class, forVariable(variable));
    }

    public QWallet(Path<? extends Wallet> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWallet(PathMetadata metadata) {
        super(Wallet.class, metadata);
    }

}

