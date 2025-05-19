package com.itacademy.aqa;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterMain {
  public static void main(String[] args) throws IOException {

    FileWriter fileWriter = null;

    try {
      fileWriter = new FileWriter("textFileExample.txt");
      fileWriter.write("Hello World!");
      fileWriter.write("\n");
      fileWriter.write("I'm writing my first file");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(fileWriter !=null){
        fileWriter.close();
      }
    }

  }
}
