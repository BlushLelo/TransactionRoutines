package com.pismo.test.pismo.test.gateway.exception;

public class GetAccountInfoGatewayException extends Exception {
    public GetAccountInfoGatewayException(String message) {
        super(message);
    }

    public GetAccountInfoGatewayException(String message, Throwable cause) {
        super(message, cause);
    }
}
