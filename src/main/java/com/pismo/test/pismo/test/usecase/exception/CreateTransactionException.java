package com.pismo.test.pismo.test.usecase.exception;

public class CreateTransactionException extends Exception {
    public CreateTransactionException(String message) {
        super(message);
    }

    public CreateTransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}
