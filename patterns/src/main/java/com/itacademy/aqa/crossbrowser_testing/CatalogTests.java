package com.itacademy.aqa.crossbrowser_testing;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.JUnitException;

import java.util.List;

public class CatalogTests {

  CatalogPage catalogPage;

  static {
    System.setProperty("browserType", "mobile");
  }

  @BeforeEach
  public void init(){

    if(System.getProperty("browserType")!=null && System.getProperty("browserType").equalsIgnoreCase("mobile")){
      catalogPage = new MobileCatalogPage();
      System.out.println("Run test in Chome");
    } else if(System.getProperty("browserType")!=null && System.getProperty("browserType").equalsIgnoreCase("desktop")){
      catalogPage = new DesktopCatalogPage();
    } else {
      throw  new JUnitException("browserType is not initialized");
    }
  }

  @Test
  public void catalogTest(){
    System.out.println("Тест на проверку наличия пунктов меню");
    catalogPage.openPage();
    catalogPage.openSection("Телевизоры");
    catalogPage.shouldHaveListItem(List.of("Samsung, Sony"));
  }

}
