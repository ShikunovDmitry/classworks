package com.itacademy.aqa.cards;

import com.itacademy.aqa.cards.exceptions.LogicalException;

public interface Exchange {
    double convert(double currency, String currencyName) throws LogicalException;
}
