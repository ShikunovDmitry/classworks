package com.itacademy.aqa.pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

public class Page {

  private Logger logger = Logger.getLogger(Page.class);

  public Page(){
    logger.trace("Init elements of the page");
  }

  @Step("Open page")
  public void open(){
    logger.info("Opening page");

    logger.debug("Looking for element by xpath to open page");

    logger.error("Element by xpath wasn't found, Can't open a page");
  }
  @Step("Checking if page is opened")
  public boolean isOpened(){
    logger.debug("Looking for element by locator");
    logger.error("element was not found");
    return true;
  }
  @Step("Clicking by element")
  public void clickByElement(String name){
    Allure.addAttachment("clicking by element locator","name");
    logger.debug("Looking for element by locator");
    logger.info("clicking by element" + name);
  }

  public boolean isElementExist(String element){
    logger.debug("Looking for element by locator");
    logger.warn(" element is exist or not" + element);
    return true;
  }
}
