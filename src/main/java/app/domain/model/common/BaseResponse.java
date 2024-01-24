package app.domain.model.common;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseResponse<T> {
    private static final String SUCCESS_STATUS = "success";
    private static final String FAIL_STATUS = "fail";

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
        return new BaseResponse<T>(SUCCESS_STATUS, ResponseCode.SUCCESS.getCode(), data, ResponseCode.SUCCESS.getMessage());
    }

    public static BaseResponse successResponse() {
        return new BaseResponse(SUCCESS_STATUS, ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    public static <T> BaseResponse<T> failResponse(Exception e) {
        e.printStackTrace();
        return new BaseResponse<>(FAIL_STATUS, ResponseCode.SERVER_ERROR.getCode(), null, ResponseCode.SERVER_ERROR.getMessage());
    }

    public static <T> BaseResponse<T> failResponse(ResponseCode e) {
        return new BaseResponse<>(FAIL_STATUS, e.getCode(), null, e.getMessage());
    }

    public static <T> BaseResponse<T> failResponse(T data, ResponseCode e) {
        return new BaseResponse<T>(FAIL_STATUS, e.getCode(), data, e.getMessage());
    }

}