package io.weeks.commons;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorMessage {

    private boolean status;
    private int code;
    private String errorMessage;
    private String referedUrl;

}
