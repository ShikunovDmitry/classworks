package com.itacademy.aqa;

//●	Даны 2 файла - in1.txt и in2.txt в каждом файле по 1000 чисел от 1 до 100000.
// Создайте файл out.txt, который будет содержать все отсортированные
// числа из файлов in1.txt и in2.txt. Файлы in1.txt и in2.txt можно создать с помощью кода.

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class App {
  public static final int BOUND = 10_000;
  public static final int AMOUNT_OF_NUMBERS = 10_000;

  public static void main(String[] args) {
    String inputFile1 = "in1.txt";
    String inputFile2 = "in2.txt";
    String outputFile = "out.txt";

    createInputFile(inputFile1);
    createInputFile(inputFile2);
    List<Integer> numbers = new ArrayList<>();
    readNumbersFromFile(inputFile1, numbers);
    readNumbersFromFile(inputFile2, numbers);

    Collections.sort(numbers);

    writeNumbersToFile(numbers, outputFile);
  }

  private static void writeNumbersToFile(List<Integer> numbers, String outputFile) {
    try (PrintWriter pr = new PrintWriter(new FileWriter(outputFile))) {
      numbers.forEach(number -> pr.println(number));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void readNumbersFromFile(String fileName, List<Integer> numbers) {
    try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = bf.readLine()) != null) {
        numbers.add(Integer.parseInt(line));
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  private static void createInputFile(String fileName) {
    try (PrintWriter pr = new PrintWriter(new FileWriter(fileName))) {

      Random random = new Random();

      for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
        pr.println(random.nextInt(BOUND));
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}
