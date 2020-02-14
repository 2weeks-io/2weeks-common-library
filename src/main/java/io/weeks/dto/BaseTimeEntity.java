package io.weeks.dto;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    @Column(name = "regDts", updatable = false)
    private LocalDateTime regDts;

    @LastModifiedDate
    @Column(name = "modDts", updatable = true)
    private LocalDateTime modDts;

    public LocalDateTime getCreatedDate() {
        return regDts;
    }

    public LocalDateTime getModifiedDate() {
        return modDts;
    }
}