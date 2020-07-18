package io.weeks.commons;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Getter
public class ResponseMessage {

    private int code;
    private boolean status;
    private String message;
    private LocalDateTime timestamp;
    private Map<String, Object> data;

    public ResponseMessage( int code, String message){
        this.code = code;
        this.status = true;
        this.message = message;
        this.timestamp = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        data = new HashMap<>();
    }

    public void add(String key, Object result) {
        this.data.put(key, result);
    }

    public void remove(String key) {
        this.data.remove(key);
    }

}
