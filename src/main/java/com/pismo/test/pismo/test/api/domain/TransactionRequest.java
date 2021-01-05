package com.pismo.test.pismo.test.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class TransactionRequest {

    @JsonProperty("account_id")
    @NotNull(message = "account_id must be informed")
    private int accountId;
    @JsonProperty("operation_type_id")
    @Min(value = 1)
    @Max(value = 4)
    private int operationTypeId;
    @Positive
    private double amount;

    public TransactionRequest(int accountId, int operationTypeId, double amount) {
        this.accountId = accountId;
        this.operationTypeId = operationTypeId;
        this.amount = amount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(int operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
