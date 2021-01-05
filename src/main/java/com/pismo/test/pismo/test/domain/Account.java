package com.pismo.test.pismo.test.domain;

import java.util.List;

public class Account {

    private int id;
    private String documentNumber;
    private List<Transaction> transactions;

    public Account() {
    }

    public Account(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Account(int id, String documentNumber) {
        this.id = id;
        this.documentNumber = documentNumber;
    }

    public Account(int id, String documentNumber, List<Transaction> transactions) {
        this.id = id;
        this.documentNumber = documentNumber;
        this.transactions = transactions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
