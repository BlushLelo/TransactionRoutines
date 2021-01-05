package com.pismo.test.pismo.test.gateway.exception;

public class CreateAccountGatewayException extends Exception {
    public CreateAccountGatewayException(String message) {
        super(message);
    }

    public CreateAccountGatewayException(String message, Throwable cause) {
        super(message, cause);
    }
}
