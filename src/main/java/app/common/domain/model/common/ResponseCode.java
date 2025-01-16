package app.common.domain.model.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS("200", "성공"),
    INVALID_ARGUMENT("400", "잘못된 요청입니다."),
    RESOURCE_NOT_FOUND("404", "리소스를 찾을 수 없습니다."),
    CONFLICT_DATA("409", "중복 된 데이터입니다."),
    SERVER_ERROR("500", "시스템 오류가 발생했습니다."),
    BAD_PARSING("900", "Json 데이터 변환 시 오류가 발생했습니다."),
    METHOD_NOT_ALLOWED("405", "허용되지 않은 메서드입니다."),
    CONSTRAINT_VIOLATION("400", "제약 조건 위반"),
    DATABASE_ERROR("500", "데이터베이스 오류"),
    ACCESS_DENIED("403", "접근이 거부되었습니다."),
    INTERNAL_SERVER_ERROR("500", "내부 서버 오류");

    private final String code;
    private final String message;

}