package app.domain.model.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS("200", "성공"),
    NOT_EXIST("404", "데이터가 존재하지 않습니다."),
    CONFLICT_DATA("409", "중복 된 데이터입니다."),
    SERVER_ERROR("500", "시스템 오류가 발생했습니다."),
    BAD_PARSING("900", "Json 데이터 변환 시 오류가 발생했습니다.");

    private final String code;
    private final String message;

}