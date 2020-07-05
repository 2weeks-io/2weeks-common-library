package io.weeks.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {

    private String status;
    private String resultCode;
    private String resultMsg;

}
