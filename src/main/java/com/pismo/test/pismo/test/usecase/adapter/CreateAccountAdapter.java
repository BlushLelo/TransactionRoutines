package com.pismo.test.pismo.test.usecase.adapter;

import com.pismo.test.pismo.test.api.domain.AccountRequest;
import com.pismo.test.pismo.test.domain.Account;

public class CreateAccountAdapter {

    public static Account translate(AccountRequest accountRequest) {
        return new Account(accountRequest.getDocumentNumber());
    }
}
