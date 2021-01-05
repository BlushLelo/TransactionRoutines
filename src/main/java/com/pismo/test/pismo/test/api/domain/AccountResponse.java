package com.pismo.test.pismo.test.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountResponse {

    @JsonProperty("document_number")
    private String documentNumber;

    public AccountResponse() {
    }

    public AccountResponse(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
