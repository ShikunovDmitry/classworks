package com.itacademy.aqa;

import java.util.*;
import java.util.stream.Collectors;

public class FindUniqueNumbers {
  public static void main(String[] args) {
    List<Integer> integerList = List.of(3, 7, 1, 3, 7, 1, 5);

    List<Integer> uniqueList = new ArrayList<>();
    for (Integer number : integerList) {
      if (!uniqueList.contains(number)) {
        uniqueList.add(number);
      }
    }
    System.out.println(uniqueList);
    Set<Integer> integerSet = integerList.stream().collect(Collectors.toSet());
    System.out.println(integerSet);
    System.out.println(new HashSet<>(integerList));

  }
}
