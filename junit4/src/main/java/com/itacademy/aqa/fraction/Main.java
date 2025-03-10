package com.itacademy.aqa.fraction;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int numerator = random.nextInt(1,10);
        int denominator = random.nextInt(1,10);


        Fraction fraction1 = new Fraction(numerator, denominator );
        System.out.println("Первая дробь: " + fraction1.show());


        numerator = random.nextInt(1,10);
        denominator = random.nextInt(1,10);
        Fraction fraction2 = new Fraction(numerator, denominator);
        System.out.println("Вторая дробь: " + fraction2.show());


        Fraction fraction3 = fraction1.sum(fraction2);
        System.out.println(" Сумма сложения дробей " + fraction3.show());

        Fraction fraction4 = fraction1.multiply(2.5);
        System.out.println(" Умножение дроби на число " + fraction4.show());

        Fraction fraction5 = fraction1.division(2.5);
        System.out.println(" Деление дроби на число " + fraction5.show());
    }
}
