package com.bank.services;

import com.bank.daos.AccountHolderDAO;
import com.bank.exceptions.InvalidRequestException;
import com.bank.exceptions.ResourcePersistenceException;
import com.bank.pojo.AccountHolder;

public class AccountHolderService {

    private AccountHolderDAO accountHolderDAO;

    public AccountHolderService(AccountHolderDAO accountHolderDAO){ this.accountHolderDAO = accountHolderDAO;}

    public void register(AccountHolder newAccountHolder) throws InvalidRequestException, ResourcePersistenceException {

       if(!isAccountHolderValid(newAccountHolder)){
           throw new InvalidRequestException ("Invalid user data");
       }

       accountHolderDAO.save(newAccountHolder);
    }

    public boolean isAccountHolderValid(AccountHolder accountHolder){
        if(accountHolder == null) return false;
        if(accountHolder.getFirstName() == null || accountHolder.getFirstName().trim().isEmpty()) return false;
        if(accountHolder.getLastName() == null || accountHolder.getLastName().trim().isEmpty()) return false;
        if(accountHolder.getEmail () == null || accountHolder.getEmail ().trim().isEmpty()) return false;
        if(accountHolder.getAge () <=0) return false;
        return true;
    }
}
