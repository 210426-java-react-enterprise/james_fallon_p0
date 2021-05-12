package com.bank.pojo;

public class Transaction {
    String type;
    Double amount;

    public Transaction() {
        this.type = null;
        this.amount = 0.00;
    }

    public Transaction(String type, Double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
