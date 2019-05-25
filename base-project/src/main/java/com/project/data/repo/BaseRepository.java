package com.project.data.repo;

import com.project.data.entity.IdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends IdEntity, PK extends Serializable> extends JpaRepository<T, PK>, JpaSpecificationExecutor<T> {

}