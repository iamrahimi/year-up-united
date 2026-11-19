package com.iamsrahimi.FinanceApplication;

public class CreditCard implements Valuable {
    private String name;
    private String accountNumber;
    private double balance;

    public CreditCard(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void charge(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Charge must be greater than zero.");
        }
        balance += amount;
    }

    public void pay(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment must be greater than zero.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Payment cannot exceed the card balance.");
        }
        balance -= amount;
    }

    @Override
    public double getValue() {
        // Here, value means the current card balance owed.
        return balance;
    }
}
