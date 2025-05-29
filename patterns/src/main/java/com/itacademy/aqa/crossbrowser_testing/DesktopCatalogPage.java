package com.itacademy.aqa.crossbrowser_testing;

import java.util.List;

public class DesktopCatalogPage extends CatalogPage{
  @Override
  public void openPage() {
    System.out.println("Opening Catalog page");
  }

  @Override
  public void shouldHaveSection(String name) {

  }

  @Override
  public void shouldHaveListItem(List<String> name) {

  }

  @Override
  public void shouldHaveDropdownItem(String sectionName) {

    System.out.println("Checking section " + sectionName);

  }

  @Override
  public void openSection(String name) {

  }

  @Override
  public void openDropdownList(String name) {

  }
}
