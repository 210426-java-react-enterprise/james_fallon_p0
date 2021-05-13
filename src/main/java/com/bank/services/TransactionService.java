package com.bank.services;

import com.bank.daos.AccountDAO;
import com.bank.exceptions.InvalidRequestException;
import com.bank.pojo.Account;
import com.bank.util.Profile;

public class TransactionService {
    private AccountDAO accountDAO;
    private Profile profile;
    private Account currentAccount;


    public TransactionService(AccountDAO accountDAO, Profile profile) {
        this.accountDAO = accountDAO;
        this.profile = profile;

    }

    public void deposit(double deposit) throws InvalidRequestException{
        if(!isAmountValid (deposit)){
            throw new InvalidRequestException("Must enter an amount greater than $0.00!");
        }

        currentAccount = profile.getCurrentAccount ();
        double newBalance = currentAccount.getAccountBalance () + deposit;
        currentAccount.setAccountBalance (newBalance);
        accountDAO.updateBalance (currentAccount);

    }

    public void withdraw(double withdrawal) throws InvalidRequestException{
        if(!isAmountValid (withdrawal)){
            throw new InvalidRequestException ("Must enter an amount greater than $0.00!");
        }
        double newBalance = profile.getCurrentAccount ().getAccountBalance () - withdrawal;

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
