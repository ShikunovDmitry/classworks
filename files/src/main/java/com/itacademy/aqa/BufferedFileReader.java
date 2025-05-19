package com.itacademy.aqa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedFileReader {
  public static void main(String[] args) {
    try(BufferedReader bufferedReader = new BufferedReader(new FileReader("bufferedWriterExample.txt"))) {
      String line;

      while ((line = bufferedReader.readLine()) !=null){
        System.out.println(line);
      }

    } catch (FileNotFoundException e) {
      System.out.println("Please create a file first");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
