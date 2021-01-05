package com.pismo.test.pismo.test.usecase;

import com.pismo.test.pismo.test.api.domain.AccountInfoResponse;
import com.pismo.test.pismo.test.gateway.GetAccountInfoGateway;
import com.pismo.test.pismo.test.gateway.exception.GetAccountInfoGatewayException;
import com.pismo.test.pismo.test.usecase.adapter.GetAccountInfoAdapter;
import com.pismo.test.pismo.test.usecase.exception.GetAccountInfoException;
import org.springframework.stereotype.Component;

@Component
public class GetAccountInfo {

    private final GetAccountInfoGateway getAccountInfoGateway;

    public GetAccountInfo(GetAccountInfoGateway getAccountInfoGateway) {
        this.getAccountInfoGateway = getAccountInfoGateway;
    }

    public AccountInfoResponse execute(int accountId) throws GetAccountInfoException {
        try {
            return GetAccountInfoAdapter.translate(getAccountInfoGateway.execute(accountId));
        } catch (GetAccountInfoGatewayException e) {
            throw new GetAccountInfoException("Account " + accountId + " could not be found", e);
        }
    }

}
