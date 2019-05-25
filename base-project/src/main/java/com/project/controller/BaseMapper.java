package com.project.controller;

import com.project.data.entity.BaseEntity;
import com.project.dto.base.BaseDto;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class BaseMapper<T, S extends BaseDto> {

    @Autowired
    protected Mapper mapper;

    protected ResponseEntity<BaseDto> toDto(T entity, S dto) {
        try {

            return ResponseEntity.ok(mapper.map(entity, dto.getClass()));

        } catch (Exception e) {
            return new ResponseEntity<BaseDto>(HttpStatus.BAD_GATEWAY);
        }
    }

    @SuppressWarnings("unchecked")
    protected ResponseEntity<List<BaseDto>> toDto(List<T> entities, S dto) {
        try {

            List<BaseDto> dtoList = new ArrayList<>();
            for (T t : entities) {
                dtoList.add(mapper.map(t,dto.getClass()));
            }

            return ResponseEntity.ok(dtoList);

        } catch (Exception e) {
            return new ResponseEntity<List<BaseDto>>(HttpStatus.BAD_GATEWAY);
        }
    }

    protected ResponseEntity<BaseDto> toDto(T entity, BaseDto baseDto, HttpStatus status) {
        try {
            return  new ResponseEntity<BaseDto>(mapper.map(entity, BaseDto.class), status);
        } catch (Exception e) {
            return new ResponseEntity<BaseDto>(HttpStatus.BAD_GATEWAY);
        }
    }

    @SuppressWarnings("unchecked")
    protected ResponseEntity<List<BaseDto>> toDto(List<T> entities, HttpStatus status) {
        try {
            List<BaseDto> dtoList = mapper.map(entities,List.class);
            return new ResponseEntity<List<BaseDto>>(dtoList, status);

        } catch (Exception e) {
            return new ResponseEntity<List<BaseDto>>(HttpStatus.BAD_GATEWAY);
        }
    }

    protected BaseEntity toEntity(T entity, S dto) {
        try {
            return (BaseEntity) mapper.map(dto, entity.getClass());
        } catch (Exception e) {
            return null;
        }
    }
}
