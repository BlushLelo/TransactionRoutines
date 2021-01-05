package com.pismo.test.pismo.test.usecase.exception;

public class GetAccountInfoException extends Exception {
    public GetAccountInfoException(String message) {
        super(message);
    }

    public GetAccountInfoException(String message, Throwable cause) {
        super(message, cause);
    }
}
