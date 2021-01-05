package com.pismo.test.pismo.test.gateway.adapter;

import com.pismo.test.pismo.test.domain.Account;
import com.pismo.test.pismo.test.gateway.mysql.model.AccountEntity;

public class CreateAccountGatewayAdapter {

    public static Account translate(AccountEntity accountEntity) {
        return new Account(accountEntity.getId(), accountEntity.getDocumentNumber());
    }
}
