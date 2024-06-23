package com.veterinary.veterinaryApp.services.servicesImp;

import com.veterinary.veterinaryApp.DTOs.AccountDTO;
import com.veterinary.veterinaryApp.Repositories.AccountRepository;
import com.veterinary.veterinaryApp.models.Account;
import com.veterinary.veterinaryApp.services.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public List<AccountDTO> getAllAccountsDto() {
        return getAllAccounts().stream().map(AccountDTO::new).collect(Collectors.toList());
    }

    @Override
    public Account getAccountById(Long id) {
        return null;
    }

    @Override
    public Account getAccountDTO(Account account) {
        return null;
    }

    @Override
    public Account saveAccount(Account account) {
        return null;
    }
}
