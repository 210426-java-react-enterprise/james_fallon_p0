package com.bank.services;

public class Transactions {

    public void deposit(double deposit, double balance){
        balance =+ deposit;
    }

    public void withdraw(double withdraw, double balance){
        balance =- withdraw;
    }
}
