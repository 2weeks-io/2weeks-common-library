package io.weeks.commons;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@ToString
@Getter
public class PageDto {

    private static final int DEFAULT_SIZE = 10;
    private static final int DEFAULT_MAX_SIZE = 50;

    private int pageNum;

    private int pageSize;

    public PageDto(){
        this.pageNum=0;
        this.pageSize=DEFAULT_SIZE;
    }

    @Builder
    public PageDto(int pageNum, int pageSize){
        this.pageNum  = pageNum;
        this.pageSize = pageSize;
    }

    public void setPageSize(int pageSize){
        this.pageSize = pageSize < DEFAULT_SIZE || pageSize > DEFAULT_MAX_SIZE ? DEFAULT_SIZE : pageSize;
    }

    public void setPageNum(int pageNum){
        this.pageNum = pageNum < 0 ? 0 : pageNum;
    }

    public Pageable makePageable(int direction, String... props){
        Sort.Direction dir = direction == 0 ? Sort.Direction.DESC : Sort.Direction.ASC;

        return PageRequest.of(this.pageNum, this.pageSize, dir, props);
    }


}
