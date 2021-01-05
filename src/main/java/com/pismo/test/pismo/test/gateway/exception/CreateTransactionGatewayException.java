package com.pismo.test.pismo.test.gateway.exception;

public class CreateTransactionGatewayException extends Exception {
    public CreateTransactionGatewayException(String message) {
        super(message);
    }

    public CreateTransactionGatewayException(String message, Throwable cause) {
        super(message, cause);
    }
}
