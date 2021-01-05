package com.pismo.test.pismo.test.api;

import com.pismo.test.pismo.test.api.domain.TransactionRequest;
import com.pismo.test.pismo.test.usecase.CreateTransaction;
import com.pismo.test.pismo.test.usecase.exception.CreateTransactionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final CreateTransaction createTransaction;

    public TransactionController(CreateTransaction createTransaction) {
        this.createTransaction = createTransaction;
    }

    @PostMapping("")
    public ResponseEntity createTransaction(@Valid @RequestBody TransactionRequest transactionRequest) throws CreateTransactionException {
        createTransaction.execute(transactionRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
