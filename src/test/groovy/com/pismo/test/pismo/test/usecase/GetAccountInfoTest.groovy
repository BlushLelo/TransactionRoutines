package com.pismo.test.pismo.test.usecase

import com.pismo.test.pismo.test.domain.Account
import com.pismo.test.pismo.test.domain.Transaction
import com.pismo.test.pismo.test.gateway.GetAccountInfoGateway
import spock.lang.Specification

import java.time.LocalDateTime

import static com.pismo.test.pismo.test.domain.Transaction.OperationType.CASH
import static com.pismo.test.pismo.test.domain.Transaction.OperationType.PAYMENT

class GetAccountInfoTest extends Specification {
    GetAccountInfoGateway getAccountInfoGateway = Mock(GetAccountInfoGateway)
    GetAccountInfo getAccountInfo = new GetAccountInfo(getAccountInfoGateway)

    def "Should retrieve account informations correctly"() {
        given: "A valid accountId"
        def accountId = 1

        when: "I call getAccountInfo"
        def accountInfo = getAccountInfo.execute(accountId)

        then: "gateway is called"
        1 * getAccountInfoGateway.execute(1)
                >> {
            args ->
                assert args[0] == 1
                List<Transaction> transactionList = new ArrayList<>()
                transactionList.add(new Transaction(1, CASH, BigDecimal.valueOf(-100), LocalDateTime.now()))
                transactionList.add(new Transaction(1, PAYMENT, BigDecimal.valueOf(100), LocalDateTime.now()))
                return new Account(1, "44504813807", transactionList)
        }

        then: "AccountInfo response should be populated correctly"
        accountInfo.accountId == 1
        accountInfo.documentNumber == "44504813807"
        accountInfo.transactions.size() == 2
    }

}

