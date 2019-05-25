package com.project.data.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.core.style.ToStringCreator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity extends IdEntity {

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    protected Date createdDate = new Date();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    protected Date lastModifiedDate = new Date();

    protected BaseEntity() {
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return getClass() == obj.getClass() && Objects.equals(identifier, ((BaseEntity) obj).identifier);
    }

    @Override
    public String toString() {
        return toString(new ToStringCreator(this)).toString();
    }

    protected ToStringCreator toString(ToStringCreator creator) {
        return creator.append("id", getIdentifier());
    }

}