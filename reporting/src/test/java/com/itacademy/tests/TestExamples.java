package com.itacademy.tests;

import com.itacademy.aqa.pages.Page;
import com.itacademy.aqa.webdriver.Browser;
import io.qameta.allure.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestExamples {
  private Logger logger = Logger.getLogger(this.getClass());

  @Test(description = "My new test")
  @Severity(SeverityLevel.CRITICAL)
  public void exampleTest() {
    logger.info("Starting new test case example");
    Page page = new Page();
    page.open();
    Assert.assertTrue(page.isOpened());
    page.clickByElement("myElement");
    Assert.assertTrue(page.isElementExist("myElement"));
    logger.info("Test case finished");
  }

  @Test
  @TmsLink("DSC-1251")
  @Severity(SeverityLevel.BLOCKER)
  public void exampleTest1() throws FileNotFoundException {
    logger.info("Starting new test case example");
    Page page = new Page();
    page.open();
    FileInputStream fis = new FileInputStream("src/test/resources/screenshot.png");

    Allure.addAttachment("Screenshot", fis);
    Assert.assertTrue(page.isOpened());
    page.clickByElement("myElement");
    Assert.assertTrue(page.isElementExist("myElement"));
    logger.info("Test case finished");
  }

  @Test
  @Link("DSC-2234")
  @Issue("DSC-1234")
  @Severity(SeverityLevel.MINOR)
  public void testExample3() throws IOException {
    logger.info("Starting new test case example");
    Page page = new Page();
    page.open();
    Assert.assertTrue(page.isOpened());
    page.clickByElement("myElement");
    Assert.assertTrue(page.isElementExist("myElement"));
    Browser.makeScreenShot();
    logger.info("Test case finished");
  }

  @Test
  @Flaky
  @Description("This is flaky test")
  @Severity(SeverityLevel.NORMAL)
  public void testExample4() {
    logger.info("Starting new test case example");
    Page page = new Page();
    page.open();
    Assert.assertTrue(page.isOpened());
    page.clickByElement("myElement");
    Assert.assertFalse(page.isElementExist("myElement"));
    logger.info("Test case finished");
  }

  @Test
  @Flaky
  @Description("This is flaky test")
  @Severity(SeverityLevel.NORMAL)
  public void testExample5() {
    logger.info("Starting new test case example");
    Page page = new Page();
    if (true) throw new RuntimeException("Hello World!");
    page.open();
    Assert.assertTrue(page.isOpened());
    page.clickByElement("myElement");
    Assert.assertFalse(page.isElementExist("myElement"));
    logger.info("Test case finished");
  }
}
