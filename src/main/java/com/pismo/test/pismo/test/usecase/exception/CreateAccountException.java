package com.pismo.test.pismo.test.usecase.exception;

public class CreateAccountException extends Exception {
    public CreateAccountException(String message) {
        super(message);
    }

    public CreateAccountException(String message, Throwable cause) {
        super(message, cause);
    }
}
