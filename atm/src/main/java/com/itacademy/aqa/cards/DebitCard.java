package com.itacademy.aqa.cards;

import com.itacademy.aqa.cards.exceptions.LogicalException;

public class DebitCard extends BankCard {
    public DebitCard() {
        super();
    }

    public DebitCard(String name, double balance) {
        super(name, balance);
    }

    public DebitCard(String name) {
        super(name);
    }

    @Override
    public void withdraw(double amount) throws LogicalException {
        if (this.getBalance() - amount < 0) {
            throw new LogicalException("Недостаточно средств на счете");
        }
        super.withdraw(amount);
    }
}
