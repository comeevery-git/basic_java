package app.common.infrastructure.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import app.common.domain.model.common.BaseResponse;
import app.common.domain.model.common.ResponseCode;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class CustomExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<BaseResponse> handleCustomException(CustomException e) {
        logger.error("CustomException occurred: ", e);
        BaseResponse response = BaseResponse.failResponse(e.getResponseCode());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<BaseResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        logger.error("IllegalArgumentException occurred: ", e);
        BaseResponse response = BaseResponse.failResponse(ResponseCode.INVALID_ARGUMENT);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    protected ResponseEntity<BaseResponse> handleNoHandlerFoundException(NoHandlerFoundException e) {
        logger.error("NoHandlerFoundException occurred: ", e);
        BaseResponse response = BaseResponse.failResponse(ResponseCode.RESOURCE_NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<BaseResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("HttpRequestMethodNotSupportedException occurred: ", e);
        BaseResponse response = BaseResponse.failResponse(ResponseCode.METHOD_NOT_ALLOWED);
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<BaseResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error("MethodArgumentNotValidException occurred: ", e);
        BaseResponse response = BaseResponse.failResponse(ResponseCode.INVALID_ARGUMENT);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<BaseResponse> handleConstraintViolationException(ConstraintViolationException e) {
        logger.error("ConstraintViolationException occurred: ", e);
        BaseResponse response = BaseResponse.failResponse(ResponseCode.CONSTRAINT_VIOLATION);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataAccessException.class)
    protected ResponseEntity<BaseResponse> handleDataAccessException(DataAccessException e) {
        logger.error("DataAccessException occurred: ", e);
        BaseResponse response = BaseResponse.failResponse(ResponseCode.DATABASE_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // @ExceptionHandler(AccessDeniedException.class)
    // protected ResponseEntity<BaseResponse> handleAccessDeniedException(AccessDeniedException e) {
    //     logger.error("AccessDeniedException occurred: ", e);
    //     BaseResponse response = BaseResponse.failResponse(ResponseCode.ACCESS_DENIED);
    //     return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    // }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<BaseResponse> handleException(Exception e) {
        logger.error("Unexpected exception occurred: ", e);
        BaseResponse response = BaseResponse.failResponse(ResponseCode.SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}