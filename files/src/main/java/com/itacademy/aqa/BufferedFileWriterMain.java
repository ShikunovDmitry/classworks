package com.itacademy.aqa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileWriterMain {
  public static void main(String[] args) {
    try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("bufferedWriterExample.txt"))) {
      bufferedWriter.write("Hello World!");
      bufferedWriter.newLine();
      bufferedWriter.write("I'm your new beginning");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
