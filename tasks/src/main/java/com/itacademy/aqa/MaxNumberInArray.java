package com.itacademy.aqa;

//Задание 2: Найти максимальное число в массиве

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxNumberInArray {


  public static void main(String[] args) {

    int[] numbers = {3, 7, 1, 15, 9, 22};

    //for(2 вида), while, do while

    int max = numbers[0];
    for (int number : numbers) {
      if (number > max) {
        max = number;
      }
    }
    System.out.println(max);

    List<Integer> integerList = Arrays.stream(numbers)
        .boxed()
        .collect(Collectors.toList());

    Integer max2 =  integerList.stream().max(Integer::compareTo).orElse(0);

    System.out.println(max2);


    Integer maxValue = Arrays.stream(numbers).max().getAsInt();

    System.out.println(maxValue);

  }
}
