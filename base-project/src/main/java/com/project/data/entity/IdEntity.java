package com.project.data.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class IdEntity implements Serializable {

    private static final int ID_LENGTH = 50;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", length = ID_LENGTH)
    protected String identifier;

    protected IdEntity() {
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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
        return obj != null && getClass() == obj.getClass() && Objects.equals(identifier, ((IdEntity) obj).identifier);
    }

    @Override
    public String toString() {
        return toString(new ToStringCreator(this)).toString();
    }

    protected ToStringCreator toString(ToStringCreator creator) {
        return creator.append("id", getIdentifier());
    }

}