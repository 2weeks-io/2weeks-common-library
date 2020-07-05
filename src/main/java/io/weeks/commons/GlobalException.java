package io.weeks.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String message;
    private String errorCode;

    public GlobalException(String message) {
        this.message = message;
    }

    public GlobalException(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

}
