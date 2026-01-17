package com.hackerrank.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidAttributeException extends RuntimeException{

    public InvalidAttributeException(String message){
        super(message);
    }
}
