package com.itacademy.aqa;

import com.itacademy.aqa.cards.Atm;
import com.itacademy.aqa.cards.BankCard;
import com.itacademy.aqa.cards.CreditCard;
import com.itacademy.aqa.cards.DebitCard;
import com.itacademy.aqa.cards.exceptions.LogicalException;

import java.util.Scanner;

public class AtmMachine {

    public static void main(String[] args) {
        Atm atm = new Atm();
        boolean exit = true;
        int typeCard = 0;
        Scanner scanner = new Scanner(System.in);

        while (exit) {
            System.out.println("Выберите тип карты, с которой хотите работать: 1 - CreditCard, 2 - DebitCard");
            boolean exitType = true;
            while (exitType) {
                try {
                    String type = scanner.next();
                    typeCard = Integer.parseInt(type);
                    if (typeCard > 2 || typeCard < 1) {
                        System.out.println("Выберите корректный тип карты");
                        continue;
                    }
                    exitType = false;
                } catch (NumberFormatException ex) {
                    System.out.println("Выберите корректный тип карты");
                }
            }
            if (typeCard == 1) {
                BankCard creditCard = new CreditCard("Name", 230);
                atm.insertCard(creditCard);
            } else if (typeCard == 2) {
                DebitCard debitCard = new DebitCard("Name", 270);
                atm.insertCard(debitCard);
            }
            boolean exitOption = true;
            while(exitOption) {
                System.out.println("Выберите операцию: 1 - Просмотреть баланс, 2 - Просмотреть баланс в другой валюте, " +
                        "3 - Пополнить баланс, 4 - Уменьшить баланс, 5 - изменить тип карты, 6 - выход из программы");
                final String option = scanner.next();
                switch (option) {
                    case "1":
                        try {
                            atm.show();
                        } catch (LogicalException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "2":
                        converter(atm, scanner);
                        break;
                    case "3":
                        sumDeposit(scanner, atm);
                        break;
                    case "4":
                        sumWithdraw(scanner, atm);
                        break;
                    case "5":
                        try {
                            atm.removeCard();
                            exitOption = false;
                        } catch (LogicalException e) {
                            System.out.println(e.getMessage());
                        }

                        break;
                    case "6":
                        System.out.println("Программа завершена!");
                        exitOption = false;
                        exit = false;
                        break;
                    default:
                        System.out.println("Выбрана некорректная операция!");
                        break;
                }
            }
        }
    }

    private static void sumWithdraw(Scanner scanner, Atm atm) {
        System.out.println("Введите сумму для уменьшения баланса: ");
        double withdraw = getCorrectVariable(scanner, "Некорректная сумма для уменьшения");
        try {
            atm.withdraw(withdraw);
            System.out.println("Баланс уменьшен! Воспользуйтесь операцией просмотра баланса");
        } catch (LogicalException ex) {
            System.out.println(ex.getMessage());
            sumWithdraw(scanner, atm);
        }
    }

    private static void sumDeposit(Scanner scanner, Atm atm) {
        System.out.println("Введите сумму для пополнения баланса: ");
        double sumDeposit = getCorrectVariable(scanner, "Некорректная сумма для пополнения");
        try {
            atm.deposit(sumDeposit);
            System.out.println("Баланс увеличен! Воспользуйтесь операцией просмотра баланса");
        } catch (LogicalException ex) {
            System.out.println(ex.getMessage());
            sumDeposit(scanner, atm);
        }
    }

    private static void converter(Atm atm, Scanner scanner) {
        System.out.println("Введите курс конверсии: ");
        double currencyResult = getCorrectVariable(scanner, "Выберите корректный курс конверсии");
        System.out.println("Введите валюту: ");
        String currencyName = scanner.next();
        try {
            atm.convert(currencyResult, currencyName);
        } catch (LogicalException ex) {
            System.out.println(ex.getMessage());
            converter(atm, scanner);
        }
    }

    private static double getCorrectVariable(Scanner scanner, String message) {
        boolean exit = true;
        double result = 0.0;
        while (exit) {
            try {
                String variable = scanner.next();
                result = Double.parseDouble(variable);
                exit = false;
            } catch (NumberFormatException ex) {
                System.out.println(message);
            }
        }
        return result;
    }
}
