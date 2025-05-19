package com.itacademy.aqa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {
  public static void main(String[] args) {
    try (FileReader fileReader = new FileReader("textFileExample.txt")) {
      int code;

      while ((code = fileReader.read()) != -1) {
        System.out.print((char) code);
      }

    } catch (FileNotFoundException e) {
      System.out.println("Please create a file first");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
