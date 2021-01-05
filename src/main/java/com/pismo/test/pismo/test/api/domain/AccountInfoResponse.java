package com.pismo.test.pismo.test.api.domain;

import java.util.List;

public class AccountInfoResponse {
    private int accountId;
    private String documentNumber;
    private List<TransactionResponse> transactions;

    public AccountInfoResponse() {
    }

    public AccountInfoResponse(int accountId, String documentNumber, List<TransactionResponse> transactions) {
        this.accountId = accountId;
        this.documentNumber = documentNumber;
        this.transactions = transactions;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public List<TransactionResponse> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionResponse> transactions) {
        this.transactions = transactions;
    }
}
