package com.pismo.test.pismo.test.api.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {
    private int id;
    private int operationType;
    private BigDecimal amount;
    private LocalDateTime eventDate;

    public TransactionResponse(int id, int operationType, BigDecimal amount, LocalDateTime eventDate) {
        this.id = id;
        this.operationType = operationType;
        this.amount = amount;
        this.eventDate = eventDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOperationType() {
        return operationType;
    }

    public void setOperationType(int operationType) {
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
}
