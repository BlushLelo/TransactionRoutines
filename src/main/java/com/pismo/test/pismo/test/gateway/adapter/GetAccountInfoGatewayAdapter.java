package com.pismo.test.pismo.test.gateway.adapter;

import com.pismo.test.pismo.test.domain.Account;
import com.pismo.test.pismo.test.domain.Transaction;
import com.pismo.test.pismo.test.gateway.mysql.model.AccountEntity;

import java.util.List;
import java.util.stream.Collectors;

public class GetAccountInfoGatewayAdapter {

    public static Account translate(AccountEntity accountEntity) {
        List<Transaction> transactionList = accountEntity.getTransactionEntities()
                .stream()
                .map(transactionEntity ->
                        new Transaction(transactionEntity.getId(),
                                Transaction.OperationType.valueOf(transactionEntity.getOperationType()),
                                transactionEntity.getAmount(),
                                transactionEntity.getEventDate())).collect(Collectors.toList()
                );
        return new Account(accountEntity.getId(), accountEntity.getDocumentNumber(), transactionList);
    }
}
