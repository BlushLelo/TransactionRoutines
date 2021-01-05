package com.pismo.test.pismo.test.usecase.adapter;

import com.pismo.test.pismo.test.api.domain.TransactionRequest;
import com.pismo.test.pismo.test.domain.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateTransactionAdapter {

    public static Transaction translate(TransactionRequest transactionRequest) {
        return new Transaction(transactionRequest.getAccountId(), Transaction.OperationType.values()[transactionRequest.getOperationTypeId() - 1], BigDecimal.valueOf(transactionRequest.getAmount()), LocalDateTime.now());
    }
}
