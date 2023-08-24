package com.teachkal.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.xpath.XPathException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyException extends RuntimeException{
    static HttpStatus httpStatus;
    public MyException(String message, HttpStatus httpStatus) {
        super(message);
        MyException.httpStatus = httpStatus;
    }

    @ControllerAdvice
    public static class MyExceptionHandler {


        @ExceptionHandler(MyException.class)
        public ResponseEntity<ExceptionData> handleMyException(MyException ex) {
            ExceptionData exceptionData = new ExceptionData(ex.getMessage(), ex.getLocalizedMessage(), new Date(), getHttpStatus(), getHttpStatus().series(), getHttpStatus().value());
            return new ResponseEntity<>(exceptionData, getHttpStatus());
        }
    }

    public static HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public class DateUtils {
        public static String formatDate(Date date, String format) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            return formatter.format(date);
        }
    }





}
