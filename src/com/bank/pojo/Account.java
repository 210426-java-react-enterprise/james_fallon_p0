package com.bank.pojo;

public class Account {
    private int accountId;
    private String accountType;
    private double accountBalance;

    public Account(int accountId, String accountType, double accountBalance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
