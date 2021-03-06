package com.bank.pojo;

import java.text.DecimalFormat;

public class Account {
    private int accountId;
    private String accountType;
    private double accountBalance;

    public Account(){
        this.accountId = 0;
        this.accountType = null;
        this.accountBalance = 0.0;
    }

    public Account(String accountType, double accountBalance) {
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    public Account(int accountId, String accountType, double accountBalance){
        this(accountType, accountBalance);
        this.accountId = accountId;
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

    @Override
    public String toString() {
        DecimalFormat ft = new DecimalFormat ("$###,###,###,###.00");
        return "Account ((((" +
                "accountId=" + accountId +
                ", accountType='" + accountType + '\'' +
                ", accountBalance=" + ft.format (accountBalance) +
                ")))))";
    }
}
