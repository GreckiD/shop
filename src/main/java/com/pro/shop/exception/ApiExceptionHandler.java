package com.pro.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException e) {
        HttpStatus httpNotFoundStatus = HttpStatus.NOT_FOUND;
        NotFoundRequest validateRequestException = new NotFoundRequest(
                "Page not found",
                httpNotFoundStatus.value()
        );
        return new ResponseEntity<>(validateRequestException, httpNotFoundStatus);
    }

}
