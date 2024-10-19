package app.common.infrastructure.exception;

import app.common.domain.model.common.ResponseCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class CustomException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ResponseCode responseCode;
    private final String additionalMessage;

    public CustomException(ResponseCode responseCode) {
        this(responseCode, null, null);
    }

    public CustomException(ResponseCode responseCode, String additionalMessage) {
        this(responseCode, additionalMessage, null);
    }

    public CustomException(ResponseCode responseCode, String additionalMessage, Throwable cause) {
        super(additionalMessage, cause);
        this.responseCode = responseCode;
        this.additionalMessage = additionalMessage;
    }

    @Override
    public String getMessage() {
        return (additionalMessage != null)
               ? responseCode.getMessage() + ": " + additionalMessage
               : responseCode.getMessage();
    }
}