package com.bank.services;

import com.bank.daos.AccountHolderDAO;
import com.bank.exceptions.InvalidRequestException;
import com.bank.exceptions.ResourcePersistenceException;
import com.bank.pojo.AccountHolder;

public class AccountHolderService {

    private AccountHolderDAO accountHolderDAO;

    public AccountHolderService(AccountHolderDAO accountHolderDAO){ this.accountHolderDAO = accountHolderDAO;}

    public void register(AccountHolder newAccountHolder) throws InvalidRequestException, ResourcePersistenceException {

       // if(!isUserValid(newAccountHolder))
    }

    public boolean isUserValid(AccountHolder accountHolder){
        if(accountHolder == null) return false;
        if(accountHolder.get)
        return true;
    }
}
