package com.pismo.test.pismo.test.usecase


import com.pismo.test.pismo.test.api.domain.TransactionRequest
import com.pismo.test.pismo.test.domain.Transaction
import com.pismo.test.pismo.test.gateway.CreateTransactionGateway
import com.pismo.test.pismo.test.gateway.exception.CreateTransactionGatewayException
import com.pismo.test.pismo.test.usecase.exception.CreateTransactionException
import spock.lang.Specification

import static com.pismo.test.pismo.test.domain.Transaction.OperationType.*

class CreateTransactionTest extends Specification {

    CreateTransactionGateway createTransactionGateway = Mock(CreateTransactionGateway)
    CreateTransaction createTransaction = new CreateTransaction(createTransactionGateway)

    def "Should create a cash transaction and amount must be adjusted"() {
        given: "A valid create transaction request"
        def transactionRequest = new TransactionRequest(1, 1, 100.0)

        when: "I call the create transaction usecase"
        createTransaction.execute(transactionRequest)

        then: "createTransactionGateway should be called with correct infos and the amount should be adjusted"
        1 * createTransactionGateway.execute(_ as Transaction) >> {
            args ->
                assert args[0].accountId == 1
                assert args[0].operationType == CASH
                assert args[0].amount == BigDecimal.valueOf(-100.00)
        }
    }

    def "Should create a installment transaction and amount must be adjusted"() {
        given: "A valid create transaction request"
        def transactionRequest = new TransactionRequest(1, 2, 200.0)

        when: "I call the create transaction usecase"
        createTransaction.execute(transactionRequest)

        then: "createTransactionGateway should be called with correct infos and the amount should be adjusted"
        1 * createTransactionGateway.execute(_ as Transaction) >> {
            args ->
                assert args[0].accountId == 1
                assert args[0].operationType == INSTALLMENT
                assert args[0].amount == BigDecimal.valueOf(-200.00)
        }
    }

    def "Should create a withDraw transaction and amount must be adjusted"() {
        given: "A valid create transaction request"
        def transactionRequest = new TransactionRequest(1, 3, 200.0)

        when: "I call the create transaction usecase"
        createTransaction.execute(transactionRequest)

        then: "createTransactionGateway should be called with correct infos and the amount should be adjusted"
        1 * createTransactionGateway.execute(_ as Transaction) >> {
            args ->
                assert args[0].accountId == 1
                assert args[0].operationType == WITHDRAW
                assert args[0].amount == BigDecimal.valueOf(-200.00)
        }
    }

    def "Should create a payment transaction and amount must be adjusted"() {
        given: "A valid create transaction request"
        def transactionRequest = new TransactionRequest(1, 4, 300.0)

        when: "I call the create transaction usecase"
        createTransaction.execute(transactionRequest)

        then: "createTransactionGateway should be called with correct infos and the amount should be adjusted"
        1 * createTransactionGateway.execute(_ as Transaction) >> {
            args ->
                assert args[0].accountId == 1
                assert args[0].operationType == PAYMENT
                assert args[0].amount == BigDecimal.valueOf(300.00)
        }
    }

    def "Should throw exception if occours an error on gateway"() {
        given: "A valid create transaction request"
        def transactionRequest = new TransactionRequest(1, 4, 300)

        when: "I call the create transaction usecase"
        createTransaction.execute(transactionRequest)

        then: "gateway is called and returns an exception"
        1 * createTransactionGateway.execute(_ as Transaction) >> {
            args ->
                throw new CreateTransactionGatewayException("Error")
        }

        then: "an exception should be thrown and the message should be correct"
        def e = thrown(CreateTransactionException)
        e.message == "Transaction could not be created"
    }
}
