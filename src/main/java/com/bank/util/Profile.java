package com.bank.util;

import com.bank.pojo.Account;
import com.bank.pojo.User;

public class Profile {
    private Account currentAccount;
    private User currentUser;


    public Profile(Account currentAccount, User currentUser) {
        this.currentAccount = currentAccount;
        this.currentUser = currentUser;
    }

    public Profile(){
        this.currentAccount = null;
        this.currentAccount = null;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
