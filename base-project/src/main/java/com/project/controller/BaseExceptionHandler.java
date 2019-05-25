package com.project.controller;

import com.project.dto.base.BaseDto;
import com.project.exception.ResourceNotFoundException;
import com.project.util.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@ControllerAdvice
public class BaseExceptionHandler <T, S extends BaseDto> extends BaseMapper {

    @ExceptionHandler(value = {ResourceNotFoundException.class })
    protected ResponseEntity<S> resourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<S>(ErrorMessages.createMesagge(e.getMessage()), e.getHttpStatus());
    }

    @ExceptionHandler(value = {TransactionSystemException.class })
    protected ResponseEntity<S> constraintViolationException(TransactionSystemException e) {
        Throwable cause = ((TransactionSystemException) e).getRootCause();
        if (cause instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) cause).getConstraintViolations();

            return new ResponseEntity<S>(ErrorMessages.createMesagge(constraintViolations.iterator().next()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<S>(ErrorMessages.createMesagge(e.getCause().getMessage()), HttpStatus.BAD_REQUEST);
    }

}
