package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.DTOs.AccountDTO;
import com.veterinary.veterinaryApp.models.Account;
import com.veterinary.veterinaryApp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-veterinary/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public ResponseEntity<?> getAllAccounts() {

        List<AccountDTO> accounts = accountService.getAllAccountsDto();

        if (accounts.isEmpty()) {
            return new ResponseEntity<>("Accounts not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
        return ResponseEntity.ok("Cuenta creada con exito");
    }
}
