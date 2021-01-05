package com.pismo.test.pismo.test.gateway;

import com.pismo.test.pismo.test.domain.Account;
import com.pismo.test.pismo.test.gateway.exception.GetAccountInfoGatewayException;

public interface GetAccountInfoGateway {
    Account execute(int accountId) throws GetAccountInfoGatewayException;
}
