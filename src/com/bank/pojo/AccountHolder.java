package com.bank.pojo;

public class AccountHolder {
    private String firstName;
    private String lastName;
    private int personalId;
    private int accountId;
    private String passWord;

    public AccountHolder(String firstName, String lastName, int personalId, int accountId, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalId = personalId;
        this.accountId = accountId;
        this.passWord = passWord;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
