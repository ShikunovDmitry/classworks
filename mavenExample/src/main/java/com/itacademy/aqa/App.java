package com.itacademy.aqa;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
//Используя maven, подключить библиотеку org.apache.commons.commons-lang3
//Создать с ее помощью массив, состоящий из 10 случайных строк, содержащих буквы.
//Превратить эти строки в названия (т.е. первая и только первая буква должна быть большой).
public class App {
    /**
     * @param args
     */
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            stringList.add(RandomStringUtils.randomAlphanumeric(10));
            System.out.println(stringList.get(i));
        }

        System.out.println("Capitalized:");

        stringList.stream().forEach(s -> {
            String capitalized = StringUtils.capitalize(s.toLowerCase());
            System.out.println(capitalized);
        });

    }
}
