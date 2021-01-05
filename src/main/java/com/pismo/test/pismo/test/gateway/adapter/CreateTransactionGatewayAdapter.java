package com.pismo.test.pismo.test.gateway.adapter;

import com.pismo.test.pismo.test.domain.Transaction;
import com.pismo.test.pismo.test.gateway.mysql.model.TransactionEntity;

public class CreateTransactionGatewayAdapter {

    public static TransactionEntity translate(Transaction transaction) {
        return new TransactionEntity(transaction.getOperationType().name(), transaction.getAmount(), transaction.getEventDate());
    }
}
