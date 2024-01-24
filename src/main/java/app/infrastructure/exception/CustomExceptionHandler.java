package app.infrastructure.exception;

import app.domain.model.common.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    protected BaseResponse handleException(Exception e) {
        return BaseResponse.failResponse(e);
    }

    @ExceptionHandler(CustomException.class)
    protected BaseResponse handleCustomException(CustomException e) {
        return BaseResponse.failResponse(e.getResponseCode());
    }

}