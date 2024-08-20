package com.example.service;
import com.example.repository.AccountRepository;
import com.example.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class AccountService {
    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accRep) {
        this.accountRepository = accRep;
    }

    public boolean accountExists(Account acc) {
        Account account = accountRepository.findByUsername(acc.getUsername());
        if(account != null) {
            return true;
        }
        return false;
    }

    public boolean accountExists(int id) {
        Account account = accountRepository.findByAccountId(id);
        if(account != null){
            return true;
        }
        return false;
    }

    public Account createAccount(Account acc) {
        return accountRepository.save(acc);
    }

    public Account loginAccount(Account acc) {
        Account account = accountRepository.findByUsernameAndPassword(acc.getUsername(), acc.getPassword());
        if(account != null) {
            return account;
        }
        return null;
    }
}
