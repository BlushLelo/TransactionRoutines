package com.pismo.test.pismo.test.api;

import com.pismo.test.pismo.test.api.domain.AccountInfoResponse;
import com.pismo.test.pismo.test.api.domain.AccountRequest;
import com.pismo.test.pismo.test.usecase.CreateAccount;
import com.pismo.test.pismo.test.usecase.GetAccountInfo;
import com.pismo.test.pismo.test.usecase.exception.CreateAccountException;
import com.pismo.test.pismo.test.usecase.exception.GetAccountInfoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/accounts")
@Validated
public class AccountsController {

    private final CreateAccount createAccount;
    private final GetAccountInfo getAccountInfo;

    public AccountsController(CreateAccount createAccount, GetAccountInfo getAccountInfo) {
        this.createAccount = createAccount;
        this.getAccountInfo = getAccountInfo;
    }

    @PostMapping("")
    public ResponseEntity createAccount(@Valid @RequestBody AccountRequest request) throws CreateAccountException {
        createAccount.execute(request);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{accountId}")
    public ResponseEntity<AccountInfoResponse> getAccountInfos(@PathVariable("accountId") int accountId) throws GetAccountInfoException {
        return new ResponseEntity<>(getAccountInfo.execute(accountId), HttpStatus.OK);
    }

}
