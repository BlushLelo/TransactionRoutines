package com.pismo.test.pismo.test.usecase

import com.pismo.test.pismo.test.api.domain.AccountInfoResponse
import com.pismo.test.pismo.test.api.domain.AccountRequest
import com.pismo.test.pismo.test.domain.Account
import com.pismo.test.pismo.test.gateway.CreateAccountGateway
import com.pismo.test.pismo.test.gateway.exception.CreateAccountGatewayException
import com.pismo.test.pismo.test.usecase.exception.CreateAccountException
import spock.lang.Specification

class CreateAccountTest extends Specification {
    CreateAccountGateway createAccountGateway = Mock(CreateAccountGateway)
    CreateAccount createAccount = new CreateAccount(createAccountGateway)

    def "Should create account sucessfully"() {
        given: "A valid accountRequest with document number"
        def accountRequest = new AccountRequest("44504813807")

        when: "I call createAccount"
        createAccount.execute(accountRequest)

        then: "gateway to create account should be called with correct infos"
        1 * createAccountGateway.execute(_ as Account) >> {
            args ->
                assert args[0].documentNumber == "44504813807"
        }
    }

    def "Should throw exception if occours an error on gateway"() {
        given: "A valid accountRequest with document number"
        def accountRequest = new AccountRequest("44504813807")

        when: "I call createAccount"
        createAccount.execute(accountRequest)

        then: "gateway is called and returns an exception"
        1 * createAccountGateway.execute(_ as Account) >> {
            args ->
                assert args[0].documentNumber == "44504813807"

                throw new CreateAccountGatewayException("Error")
        }

        then: "an exception should be thrown and the message should be correct"
        def e = thrown(CreateAccountException)
        e.message == "The account could not be created"
    }
}
