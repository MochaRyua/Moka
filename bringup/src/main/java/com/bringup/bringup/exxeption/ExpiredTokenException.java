package com.bringup.bringup.exxeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.GONE)
public class ExpiredTokenException extends RuntimeException{

    public ExpiredTokenException() {
        super();
    }
}
