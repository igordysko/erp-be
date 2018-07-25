package com.objectify.erp.application.controller;

import com.objectify.erp.domain.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler(value = { ResourceNotFoundException.class })
    protected ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        LOGGER.debug("Resource not found. Returning 404", ex);
        return handleExceptionInternal(ex, null,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleAllOtherExceptions(Exception ex, WebRequest request) {
        LOGGER.error("General exception. Returning 500", ex);
        return handleExceptionInternal(ex, null,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
