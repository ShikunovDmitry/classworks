package com.itacademy.aqa;

import java.util.Random;

public class ExceptionThrower {

    public void thrower() {
        int value = new Random().nextInt(10);

        if (value > 5)
            throw new SecurityException("Here I'm");
    }
}
