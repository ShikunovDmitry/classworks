package com.itacademy.aqa.cards;

import com.itacademy.aqa.cards.exceptions.LogicalException;

public abstract class BankCard implements Card, Exchange {

    private String name;
    private double balance;

    public BankCard() {
        this("", 0.0);
    }

    public BankCard(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    public BankCard(String name) {
        this(name, 0.0);
    }

    @Override
    public void deposit(double amount) throws LogicalException {
        if (amount <= 0) {
            throw new LogicalException("Для пополнения денежных средств необходимо ввести сумму больше 0");
        }
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) throws LogicalException {
        if (amount <= 0) {
            throw new LogicalException("Для снятия денежных средств необходимо ввести сумму больше 0");
        }
        this.balance -= amount;
    }

    @Override
    public Double getBalance() {
        return this.balance;
    }

    @Override
    public double convert(double currency, String currencyName) throws LogicalException {
        if (currency <= 0) {
            throw new LogicalException("Курс конверсии должен быть больше 0");
        }
        double v = this.balance / currency;
        System.out.println("Баланс счета в валюте " + currencyName + " равен " + v);
        return v;
    }
}
