package com.pismo.test.pismo.test.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private int accountId;
    private OperationType operationType;
    private BigDecimal amount;
    private LocalDateTime eventDate;

    public Transaction() {
    }

    public Transaction(int accountId, OperationType operationType, BigDecimal amount, LocalDateTime eventDate) {
        this.accountId = accountId;
        this.operationType = operationType;
        this.amount = amount;
        this.eventDate = eventDate;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public enum OperationType {
        CASH(1),
        INSTALLMENT(2),
        WITHDRAW(3),
        PAYMENT(4);

        private int value;

        private OperationType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }


    public void adjustAmount() {
        switch (operationType) {
            case CASH:
            case INSTALLMENT:
            case WITHDRAW: {
                this.amount = this.amount.negate();
                break;
            }
        }
    }
}
