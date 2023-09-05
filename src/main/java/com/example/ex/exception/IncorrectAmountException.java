package com.example.ex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectAmountException extends RuntimeException {
    public IncorrectAmountException(String message) {
        super(message);
    }
}
