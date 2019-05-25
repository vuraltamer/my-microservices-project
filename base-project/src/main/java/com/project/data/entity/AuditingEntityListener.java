package com.project.data.entity;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Component
public class AuditingEntityListener {

    @PrePersist
    @PreUpdate
    public void setLastModifiedDate(BaseEntity entity) {
        if (StringUtils.isBlank(entity.getIdentifier()) || entity.getCreatedDate() == null) {
            entity.setCreatedDate(new Date());
        }
        entity.setLastModifiedDate(new Date());
    }
}