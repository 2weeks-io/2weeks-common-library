package io.weeks.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String message;
    private int code;

    public GlobalException(String message, int code) {
        this.message = message;
        this.code = code;
    }

}
