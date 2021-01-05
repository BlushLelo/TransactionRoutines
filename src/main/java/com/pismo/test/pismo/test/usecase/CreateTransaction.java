package com.pismo.test.pismo.test.usecase;

import com.pismo.test.pismo.test.api.domain.TransactionRequest;
import com.pismo.test.pismo.test.domain.Transaction;
import com.pismo.test.pismo.test.gateway.CreateTransactionGateway;
import com.pismo.test.pismo.test.gateway.exception.CreateTransactionGatewayException;
import com.pismo.test.pismo.test.usecase.adapter.CreateTransactionAdapter;
import com.pismo.test.pismo.test.usecase.exception.CreateTransactionException;
import org.springframework.stereotype.Component;

@Component
public class CreateTransaction {

    private final CreateTransactionGateway createTransactionGateway;

    public CreateTransaction(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    public void execute(TransactionRequest transactionRequest) throws CreateTransactionException {
        Transaction transaction = CreateTransactionAdapter.translate(transactionRequest);
        transaction.adjustAmount();
        try {
            createTransactionGateway.execute(transaction);
        } catch (CreateTransactionGatewayException e) {
            throw new CreateTransactionException("Transaction could not be created", e);
        }
    }
}
