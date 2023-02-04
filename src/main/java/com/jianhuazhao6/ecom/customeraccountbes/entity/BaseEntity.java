package com.jianhuazhao6.ecom.customeraccountbes.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
@SuperBuilder
@NoArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreatedDate
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Instant createdDate;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Instant modifiedDate;
    @CreatedBy
    @Column
    private String createdUser;
    @LastModifiedBy
    @Column
    private String modifiedUser;
    @Version
    @Column(name = "version")
    private Integer version;
}
