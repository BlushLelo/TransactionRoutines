
package com.pismo.test.pismo.test.gateway.impl;

import com.pismo.test.pismo.test.domain.Account;
import com.pismo.test.pismo.test.gateway.CreateAccountGateway;
import com.pismo.test.pismo.test.gateway.adapter.CreateAccountGatewayAdapter;
import com.pismo.test.pismo.test.gateway.exception.CreateAccountGatewayException;
import com.pismo.test.pismo.test.gateway.mysql.model.AccountEntity;
import com.pismo.test.pismo.test.gateway.mysql.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountGatewayImpl implements CreateAccountGateway {

    private final AccountRepository accountRepository;

    public CreateAccountGatewayImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account execute(Account account) throws CreateAccountGatewayException {
        try {
            return CreateAccountGatewayAdapter.translate(accountRepository.save(new AccountEntity(account.getDocumentNumber())));
        } catch (Exception e) {
            throw new CreateAccountGatewayException("Problem creating account on database");
        }
    }
}
