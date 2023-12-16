package com.github.shortener.urlshortener.exceptions.handler;

import com.github.shortener.urlshortener.exceptions.errors.StandardUrlAlreadyExistsException;
import com.github.shortener.urlshortener.exceptions.errors.StandardUrlNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(value = NOT_FOUND)
    @ExceptionHandler(StandardUrlNotFoundException.class)
    public Map<String, Object> genericNotFoundExceptionHandler(RuntimeException ex) {
        return setUpMessage(NOT_FOUND.value(), NOT_FOUND.name(), ex.getMessage());
    }

    @ExceptionHandler(StandardUrlAlreadyExistsException.class)
    public  Map<String, Object> genericBadRequestExceptionHandler(RuntimeException ex) {
        return setUpMessage(BAD_REQUEST.value(), BAD_REQUEST.name(), ex.getMessage());
    }

    private Map<String, Object> setUpMessage(int httpCode, String httpStatus, String msg) {
        Map<String, Object> response = new ConcurrentHashMap<>();
        response.put("HTTP_CODE", httpCode);
        response.put("HTTP_STATUS", httpStatus);
        response.put("TIMESTAMP", Instant.now());
        response.put("MESSAGE", msg);
        return response;
    }
}
