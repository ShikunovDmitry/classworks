package com.itacademy.aqa.webdriver;

import io.qameta.allure.Attachment;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Browser {

  @Attachment
  public static byte[] makeScreenShot() throws IOException {
    //return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    FileInputStream fis = new FileInputStream("src/test/resources/screenshot.png");
    byte[] screenshot = new byte[(int)Files.size(Paths.get("src/test/resources/screenshot.png"))];
    fis.read(screenshot);
    fis.close();
    return screenshot;
  }
}
