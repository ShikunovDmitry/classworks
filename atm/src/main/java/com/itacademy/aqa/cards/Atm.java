package com.itacademy.aqa.cards;

import com.itacademy.aqa.cards.exceptions.LogicalException;

public class Atm {
    private BankCard bankCard = null;

    public void insertCard(BankCard bankCard) {
        if (this.bankCard != null) {
            System.out.println("Карта уже вставлена в банкомат");
            return;
        }
        this.bankCard = bankCard;
    }

    public void removeCard() throws LogicalException {
        if (bankCard != null) {
            bankCard = null;
        } else {
            throw new LogicalException("Карта не вставлена");
        }
    }

    public void withdraw(double amount) throws LogicalException {
        if (bankCard != null) {
            bankCard.withdraw(amount);
        } else {
            throw new LogicalException("Карта не вставлена");
        }
    }

    public double show() throws LogicalException {
        if (bankCard != null) {
            return bankCard.getBalance();
        } else {
            throw new LogicalException("Карта не вставлена");
        }
    }

    public void deposit(double amount) throws LogicalException {
        if (bankCard != null) {
            bankCard.deposit(amount);
        } else {
            throw new LogicalException("Карта не вставлена");
        }
    }

    public void convert(double currency, String currencyName) throws LogicalException {
        if (bankCard != null) {
            bankCard.convert(currency, currencyName);
        } else {
            throw new LogicalException("Карта не вставлена");
        }
    }
}
