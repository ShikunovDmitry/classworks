package com.itacademy.aqa;
import java.io.*;
import java.util.Random;

//●	Записать в двоичный файл 30 случайных чисел от 1 до 100. Прочитать записанный файл распечатать числа и их среднее арифметическое.

public class BinaryFileDemo {
    public static void main(String[] args) {
        String fileName = "numbers.bin";
        int count = 30;

        // Запись 30 случайных чисел от 1 до 100 в двоичный файл
        writeRandomNumbersToFile(fileName, count);

        // Чтение из двоичного файла, печать чисел и вычисление среднего арифметического
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            int sum = 0;
            System.out.print("Числа из файла: ");
            for (int i = 0; i < count; i++) {
                int number = dataInputStream.readInt();
                sum += number;
                System.out.print(number + " ");
            }
            System.out.println();

            double average = (double) sum / count;
            System.out.println("Среднее арифметическое чисел: " + average);

            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Запись 30 случайных чисел от 1 до 100 в двоичный файл
    private static void writeRandomNumbersToFile(String fileName, int count) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            Random random = new Random();

            for (int i = 0; i < count; i++) {
                int number = random.nextInt(100) + 1;
                dataOutputStream.writeInt(number);
            }

            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

