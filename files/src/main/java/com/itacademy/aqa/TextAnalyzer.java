package com.itacademy.aqa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextAnalyzer {
  ////Создать файл с текстом, прочитать, подсчитать в тексте количество знаков препинания и слов.
  public static void main(String[] args) {

    String fileToAnalyze = "src/text.txt";

    int wordCount = 0;
    int punctuationCount = 0;

    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToAnalyze))) {

      String line;
      while ((line = bufferedReader.readLine()) != null){
        String[] words = line.split("\\s+");
        wordCount += words.length;

        for( char c : line.toCharArray()){
          if(Character.toString(c).matches("\\p{Punct}")){
            punctuationCount++;
          }
        }
      }

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Words count = " + wordCount);
    System.out.println("Punctuation count = " + punctuationCount);
  }
}
