package io.weeks.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class BaseDto {

    private int pageNum;

    private int pageSize;

    private String regpeId;

    private String modpeId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modDts;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regDts;

}
