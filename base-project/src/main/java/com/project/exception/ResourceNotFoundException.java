package com.project.exception;

import com.project.util.BaseUtil;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException {

    private HttpStatus httpStatus = HttpStatus.OK;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ResourceNotFoundException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

}