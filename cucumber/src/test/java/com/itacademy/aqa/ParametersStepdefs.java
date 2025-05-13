package com.itacademy.aqa;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.it.Ma;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ParametersStepdefs {
  @Given("^there is collection of elements (.+)$")
  public void thereIsCollectionOfElementsElementElement(List<String> list) {
    Assert.assertTrue(list.size()>0);
  }

  @And("some other elements {stringList} exist")
  public void someOtherElementsElementElementExist(List<String> list) {
    Assert.assertTrue(list.size()>0);
  }

  @Given("there are elements")
  public void thereAreElements(List<String> elements) {
    Assert.assertTrue(elements.size()>0);
  }

  @Given("there is map of string element")
  public void thereIsMapOfElement(Map<String, String> map) {
    Assert.assertTrue(map.size()>0);
  }

  @And("there is a map of integer elements")
  public void thereIsAMapOfIntegerElements(Map<String, Integer> map) {
    Assert.assertTrue(map.size()>0);
  }

  @And("there is a map of boolean elements")
  public void thereIsAMapOfBooleanElements(Map<String, Boolean> map) {
    Assert.assertTrue(map.size()>0);
  }

  @Given("menu objects are available")
  public void menuObjectsAreAvailable(List<Menu> list) {
    Assert.assertTrue(list.size()>0);
  }

  @DataTableType
  public Menu menuEntryTransformer(Map<String, String> row){
    return new Menu(row.get("title"),
        Boolean.parseBoolean(row.get("isAvailable")),
        Integer.parseInt(row.get("subMenuCount")));
  }
}
