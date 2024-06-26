package app.common.domain.model.common;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseResponse<T> {
    private static final String SUCCESS = CommonCode.STATUS_SUCCESS;
    private static final String FAIL = CommonCode.STATUS_FAIL;

    private String status;
    private String code;
    private T data;
    private String message;

    private BaseResponse(String status, String code, T data, String message) {
        this.status = status;
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.data = null;
        this.message = message;
    }

    public static <T> BaseResponse<T> successResponse(T data) {
        return new BaseResponse<T>(SUCCESS, ResponseCode.SUCCESS.getCode(), data, ResponseCode.SUCCESS.getMessage());
    }

    public static BaseResponse successResponse() {
        return new BaseResponse(SUCCESS, ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    public static BaseResponse failResponse(Exception e) {
        e.printStackTrace();
        return new BaseResponse<>(FAIL, ResponseCode.SERVER_ERROR.getCode(), null, ResponseCode.SERVER_ERROR.getMessage());
    }

    public static BaseResponse failResponse(ResponseCode e) {
        return new BaseResponse<>(FAIL, e.getCode(), null, e.getMessage());
    }

    public static <T> BaseResponse<T> failResponse(T data, ResponseCode e) {
        return new BaseResponse<T>(FAIL, e.getCode(), data, e.getMessage());
    }

}