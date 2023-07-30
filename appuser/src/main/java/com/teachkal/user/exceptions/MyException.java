package com.teachkal.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class MyException extends RuntimeException{
    public MyException(String message) {
        super(message);
    }

    @ControllerAdvice
    public static class MyExceptionHandler {
        @ExceptionHandler(MyException.class)
        public ResponseEntity<String> handleMyException(MyException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
