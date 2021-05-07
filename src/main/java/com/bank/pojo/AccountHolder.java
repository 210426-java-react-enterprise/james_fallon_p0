package com.bank.pojo;

public class AccountHolder {
    private String firstName;
    private String lastName;
    private int personalId;
    private String passWord;

    public AccountHolder(String firstName, String lastName, int personalId, int accountId, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalId = personalId;
        this.passWord = passWord;
    }

    public AccountHolder(){
        this.firstName = null;
        this.lastName = null;
        this.personalId = 0;
        this.passWord = null;

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
