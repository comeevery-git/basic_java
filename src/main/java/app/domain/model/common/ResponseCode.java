package app.domain.model.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS("200", "성공"),
    RESULT_NOT_EXIST("404", "데이터가 존재하지 않습니다."),
    SERVER_ERROR("500", "시스템 오류가 발생했습니다.");

    private final String code;
    private final String message;

}