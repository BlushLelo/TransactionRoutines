package com.pismo.test.pismo.test.usecase;

import com.pismo.test.pismo.test.api.domain.AccountRequest;
import com.pismo.test.pismo.test.gateway.CreateAccountGateway;
import com.pismo.test.pismo.test.gateway.exception.CreateAccountGatewayException;
import com.pismo.test.pismo.test.usecase.adapter.CreateAccountAdapter;
import com.pismo.test.pismo.test.usecase.exception.CreateAccountException;
import org.springframework.stereotype.Component;

@Component
public class CreateAccount {

    private final CreateAccountGateway createAccountGateway;

    public CreateAccount(CreateAccountGateway createAccountGateway) {
        this.createAccountGateway = createAccountGateway;
    }

    public void execute(AccountRequest accountRequest) throws CreateAccountException {
        try {
            createAccountGateway.execute(CreateAccountAdapter.translate(accountRequest));
        } catch (CreateAccountGatewayException e) {
            throw new CreateAccountException("The account could not be created", e);
        }
    }
}
