package com.teachkal.user.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ExceptionData {
    public String message;
    public String localizedMessage;
    public String date;
    public HttpStatus code;

    public ExceptionData(String message, String localizedMessage, Date date, HttpStatus httpStatus) {
        this.message = message;
        this.localizedMessage = localizedMessage;
        this.date = formatDate(date);
        this.code = httpStatus;

    }

    public String formatDate(Date date) {
        return MyException.DateUtils.formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

}
