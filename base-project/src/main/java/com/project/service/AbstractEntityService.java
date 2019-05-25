package com.project.service;

import com.project.data.entity.BaseEntity;
import com.project.data.repo.BaseRepository;
import com.project.exception.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractEntityService<T extends BaseEntity, PK extends Serializable> {

    public static final Logger logger = LogManager.getLogger(AbstractEntityService.class);

    public abstract BaseRepository<T, PK> getRepository();

    @Transactional
    public T save(T entity) {
        entity.setIdentifier("");
        return getRepository().save(entity);
    }

    @Transactional
    public T update(T forSave) {
        T theReal = getEntity((PK) forSave.getIdentifier());
        forSave.setCreatedDate(theReal.getCreatedDate());
        return getRepository().save(forSave);
    }

    @Transactional
    public String delete(PK id) {
        T entity = getEntity(id);
        getRepository().delete(entity);
        return "OK";
    }


    @Transactional
    public T getEntity(PK id) {
        Optional<T> entity = Optional.ofNullable(getRepository().findOne(id));
        if (!entity.isPresent()) {
            throw new ResourceNotFoundException(HttpStatus.OK, id + " is not found!");
        }
        return entity.get();
    }

    @Transactional
    public List<T> all() {
        return getRepository().findAll();
    }


}