package com.itacademy.aqa.crossbrowser_testing;

import java.util.List;

public abstract class CatalogPage {

  abstract public void openPage();

  abstract public void shouldHaveSection(String name);

  abstract public void shouldHaveListItem(List<String> name);

  abstract public void shouldHaveDropdownItem(String sectionName);

  abstract public void openSection(String name);

  abstract public void openDropdownList(String name);


}
