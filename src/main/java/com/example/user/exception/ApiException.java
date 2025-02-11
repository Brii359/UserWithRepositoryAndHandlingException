package com.example.user.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {
    @Getter
    private final String message;
    @Getter
    private final Throwable throwable;
    @Getter
    private final HttpStatus httpStatus;
    @Getter
    private final ZonedDateTime zonedDateTime;

    public ApiException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.zonedDateTime = zonedDateTime;
    }



    @Override
    public String   toString() {
        return "ApiException{" +
                "message=" + message +
                ", throwable=" + throwable +
                ", httpStatus=" + httpStatus +
                ", zonedDateTime=" + zonedDateTime +
                '}';
    }
}