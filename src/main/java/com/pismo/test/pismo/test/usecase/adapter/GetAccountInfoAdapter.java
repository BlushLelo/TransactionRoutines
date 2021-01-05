package com.pismo.test.pismo.test.usecase.adapter;

import com.pismo.test.pismo.test.api.domain.AccountInfoResponse;
import com.pismo.test.pismo.test.api.domain.TransactionResponse;
import com.pismo.test.pismo.test.domain.Account;

import java.util.List;
import java.util.stream.Collectors;

public class GetAccountInfoAdapter {
    public static AccountInfoResponse translate(Account account) {
        List<TransactionResponse> transactionResponses = account.getTransactions()
                .stream()
                .map(transaction ->
                        new TransactionResponse(transaction.getAccountId(), transaction.getOperationType().getValue(),
                                transaction.getAmount(), transaction.getEventDate())).collect(Collectors.toList()
                );
        return new AccountInfoResponse(account.getId(), account.getDocumentNumber(), transactionResponses);
    }
}
