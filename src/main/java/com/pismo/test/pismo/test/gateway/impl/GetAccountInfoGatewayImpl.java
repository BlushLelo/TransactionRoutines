package com.pismo.test.pismo.test.gateway.impl;

import com.pismo.test.pismo.test.domain.Account;
import com.pismo.test.pismo.test.gateway.GetAccountInfoGateway;
import com.pismo.test.pismo.test.gateway.adapter.GetAccountInfoGatewayAdapter;
import com.pismo.test.pismo.test.gateway.exception.GetAccountInfoGatewayException;
import com.pismo.test.pismo.test.gateway.mysql.model.AccountEntity;
import com.pismo.test.pismo.test.gateway.mysql.repository.AccountRepository;
import com.pismo.test.pismo.test.gateway.mysql.repository.TransactionRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetAccountInfoGatewayImpl implements GetAccountInfoGateway {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public GetAccountInfoGatewayImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Account execute(int accountId) throws GetAccountInfoGatewayException {
        Optional<AccountEntity> account = accountRepository.findById(accountId);
        if (account.isPresent()) {
            return GetAccountInfoGatewayAdapter.translate(account.get());
        }
        throw new GetAccountInfoGatewayException("Problem finding account on database");
    }
}
