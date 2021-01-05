package com.pismo.test.pismo.test.gateway;

import com.pismo.test.pismo.test.domain.Account;
import com.pismo.test.pismo.test.gateway.exception.CreateAccountGatewayException;

public interface CreateAccountGateway {
    Account execute(Account account) throws CreateAccountGatewayException;
}
