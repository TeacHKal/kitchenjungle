package com.teachkal.user.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ExceptionData {
    public String message;
    public String localizedMessage;
    public String date;
    public HttpStatus httpStatus;
    public HttpStatus.Series series;
    public int code;

    public ExceptionData(String message, String localizedMessage, Date date, HttpStatus httpStatus, HttpStatus.Series series, int value) {
        this.message = message;
        this.localizedMessage = localizedMessage;
        this.date = formatDate(date);
        this.httpStatus = httpStatus;
        this.series = series;
        this.code = value;

    }

    public String formatDate(Date date) {
        return MyException.DateUtils.formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

}
