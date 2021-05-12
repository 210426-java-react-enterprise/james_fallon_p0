package com.bank.services;

import com.bank.daos.AccountDAO;
import com.bank.exceptions.InvalidRequestException;
import com.bank.pojo.Account;

public class TransactionService {
    private AccountDAO accountDAO;

    public TransactionService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    public void deposit(double deposit, Account currentAccount) throws InvalidRequestException{
        if(!isAmountValid (deposit)){
            throw new InvalidRequestException("Must enter an amount greater than $0.00!");
        }
        double newBalance = currentAccount.getAccountBalance () + deposit;
        currentAccount.setAccountBalance (newBalance);
        accountDAO.updateBalance (currentAccount);

    }

    public void withdraw(double withdrawal, Account currentAccount) throws InvalidRequestException{
        if(!isAmountValid (withdrawal)){
            throw new InvalidRequestException ("Must enter an amount greater than $0.00!");
        }

        double newBalance = currentAccount.getAccountBalance () - withdrawal;

        if(!isBalanceValid (newBalance)){
            throw new InvalidRequestException ("Balance can not be overdrawn");
        }

        currentAccount.setAccountBalance (newBalance);
        accountDAO.updateBalance (currentAccount);



    }

    public boolean isAmountValid(double deposit){
        if(deposit <= 0) return false;
        return true;
    }

    public boolean isBalanceValid(double balance){
        if(balance < 0) return false;
        return true;
    }
}
