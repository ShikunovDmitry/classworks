package com.itacademy.aqa.cards;

import com.itacademy.aqa.cards.exceptions.LogicalException;

public interface Card {
    void deposit(double amount) throws LogicalException;
    void withdraw(double amount) throws LogicalException;
    Double getBalance();
}
