package com.pismo.test.pismo.test.gateway;

import com.pismo.test.pismo.test.domain.Transaction;
import com.pismo.test.pismo.test.gateway.exception.CreateTransactionGatewayException;

public interface CreateTransactionGateway {
    void execute(Transaction transaction) throws CreateTransactionGatewayException;
}
