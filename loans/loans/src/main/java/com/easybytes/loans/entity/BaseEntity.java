package com.easybytes.loans.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Column(name = "created_By",updatable = false)
    @CreatedBy
    private String createdBy;

    @Column(name="created_at",updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name="updated_by",insertable = false)
    @LastModifiedBy
    private String updatedBy;

    @Column(name="updated_at",insertable = false)
    @LastModifiedDate
    private String updatedAt;
}
