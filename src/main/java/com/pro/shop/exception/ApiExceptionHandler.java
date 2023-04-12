package com.pro.shop.exception;

import com.pro.shop.admin.repsonse.MessageResponse;
import com.pro.shop.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        MessageResponse validateResponseException = new MessageResponse(
                false,
                "Page not found",
                status.value()
        );
        return new ResponseEntity<>(validateResponseException, status);
    }


}
