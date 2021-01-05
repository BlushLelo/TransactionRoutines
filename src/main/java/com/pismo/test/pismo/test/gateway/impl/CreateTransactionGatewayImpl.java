package com.pismo.test.pismo.test.gateway.impl;

import com.pismo.test.pismo.test.domain.Transaction;
import com.pismo.test.pismo.test.gateway.CreateTransactionGateway;
import com.pismo.test.pismo.test.gateway.adapter.CreateTransactionGatewayAdapter;
import com.pismo.test.pismo.test.gateway.exception.CreateTransactionGatewayException;
import com.pismo.test.pismo.test.gateway.mysql.model.AccountEntity;
import com.pismo.test.pismo.test.gateway.mysql.model.TransactionEntity;
import com.pismo.test.pismo.test.gateway.mysql.repository.AccountRepository;
import com.pismo.test.pismo.test.gateway.mysql.repository.TransactionRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateTransactionGatewayImpl implements CreateTransactionGateway {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public CreateTransactionGatewayImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void execute(Transaction transaction) throws CreateTransactionGatewayException {
        try {
            AccountEntity accountEntity = accountRepository.getOne(transaction.getAccountId());
            TransactionEntity transactionEntity = CreateTransactionGatewayAdapter.translate(transaction);
            transactionEntity.setAccountEntity(accountEntity);
            transactionRepository.save(transactionEntity);
        } catch (Exception e) {
            throw new CreateTransactionGatewayException("Could not create transaction on database");
        }
    }
}
