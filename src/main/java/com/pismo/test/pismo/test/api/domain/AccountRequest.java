package com.pismo.test.pismo.test.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AccountRequest {

    @JsonProperty("document_number")
    @NotBlank(message = "document_number needs to be informed")
    @Size(min = 11, max = 11)
    private String documentNumber;

    public AccountRequest() {
    }

    public AccountRequest(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
