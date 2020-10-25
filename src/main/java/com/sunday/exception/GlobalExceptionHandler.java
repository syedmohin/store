package com.sunday.exception;

import com.sunday.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorModel> exceptionhandler(Exception ex, WebRequest wq) {
        return new ResponseEntity<>(new ErrorModel(ex.getMessage(), wq.getDescription(false)), HttpStatus.BAD_REQUEST);
    }
}
