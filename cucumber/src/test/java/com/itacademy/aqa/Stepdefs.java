package com.itacademy.aqa;

import com.itacademy.aqa.bank.Account;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
public class Stepdefs {
  Account account;

    @Given("На счете пользователя имеется {int} рублей")
//  @Given("^На счете пользователя имеется (\\d+) рублей$")
  public void thereIsAmountOfMoneyOnTheAccount(Integer amount) {
    account = new Account();
    account.setBalance(amount);
  }

  @When("Пользователь снимает {int} рублей")
  public void userWithdrawal(Integer withdrawalAmount) {
    account.withdraw(withdrawalAmount);
  }

  @Then("На счете пользователя  остается {int} рублей")
  public void thereIsExpectedBalanceOnTheAccount(int expectedBalance) {
    Assert.assertEquals("Баланс не верен после снятия", expectedBalance, account.getBalance());
  }

  @Then("Появилось предупреждение {string}")
  public void thereIsMessage(String expectedMessage) {
      Assert.assertEquals("Сообщения не соответствуют", expectedMessage, account.getLastResult());
  }

  @And("(.+) доволен")
  public void userIsSatisfied() {
      Assert.assertTrue(account.getBalance() > 0);
  }

  @BeforeStep
  public void beforeStep(){
    System.out.println("before step");
  }
  @AfterStep("~@Positive")
  //@AfterStep("not @Positive")
  public void afterStepMethod(){
    System.out.println("afterStep");
  }

  @After
  public void afterScenario(){
    System.out.println("after scenario");
  }
  @Before("@Negative")
  public void beforeMethod(){
    System.out.println("beforeMethod");
  }
}
