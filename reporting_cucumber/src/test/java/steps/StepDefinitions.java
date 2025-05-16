package steps;

import enums.MenuEnum;
import io.cucumber.java.After;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.MainPage;
import utils.AssertInterface;
import utils.AssertUtils;
import utils.WebDriverRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StepDefinitions {

    private static Logger log = Logger.getLogger("Test steps");

    private Properties properties = new Properties();

    private MainPage mainPage = new MainPage();

    @Дано("открыт сайт onliner.by")
    public void openOnliner() throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        properties.load(new FileInputStream("src/test/resources/project.properties"));
        log.info("Opening " + properties.getProperty("siteUrl"));
        log.info("Тест запускается в  " + "Chrome");
        WebDriverRunner.getDriver().get(properties.getProperty("siteUrl"));
        WebDriverRunner.getDriver().manage().window().maximize();
    }

    @Когда("наведен курсор на пункт {string}")
    public void autoHover(String menuItem) {
        log.info("Наводим курсор на  " + menuItem);

        Allure.addAttachment("Step","Наводим курсор на " + menuItem);
        mainPage.showMenuByItem(menuItem);
    }

    @Когда("наведен курсор на пункт {} enum")
    public void autoHoverByEnum(MenuEnum menuItem) {
        log.info("Наводим курсор на  " + menuItem.getMenuText());
        Allure.description("Наводим курсор на  " + menuItem.getMenuText());
        Allure.addAttachment("Step","Наводим курсор на " + menuItem.getMenuText());
        mainPage.showMenuByItem(menuItem);
    }

    private static String[] autoCategories = new String[]{"Новые авто", "С пробегом", "Цена с НДС", "Авто до 4000 р.", "Авто до 10 000 р.", "Авто до 20 000 р."};
    private static String[] cities = new String[]{"Минск", "Гомель", "Могилев", "Витебск", "Гродно", "Брест"};
    private static String[] models = new String[]{"Audi", "BMW", "Citroen", "Ford", "Mazda", "Mercedes-Benz", "Nissan", "Opel", "Peugeot", "Renault", "Toyota", "Volkswagen"};

    @Тогда("появляется подменю с категориями, разграниченным по ценам ,по городам, и по маркам")
    public void assertAutoDropdown() {
        List<AssertInterface> assertList = new ArrayList<>();
        for (String autoCategory : autoCategories) {
            assertList.add(() -> Assert.assertTrue(mainPage.isDropdownItemVisible(autoCategory)));
        }
        for (String city : cities) {
            assertList.add(() -> Assert.assertTrue(mainPage.isDropdownItemVisible(city)));
        }
        for (String model : models) {
            assertList.add(() -> Assert.assertTrue(mainPage.isDropdownItemVisible(model)));
        }
        AssertUtils.assertAll(assertList.toArray(new AssertInterface[1]));
    }


    @Тогда("появляется подменю с категориями, разграниченным по городам, количеством комнат, ценовым диапазоном")
    public void assertHouses() {
        AssertUtils.assertAll(
            () -> Assert.assertTrue("Нет городов", mainPage.isDropdownItemVisible("Минск")),
                () -> Assert.assertTrue("Нет комнат", mainPage.isDropdownItemVisible("1-комнатные")),
                () -> Assert.assertTrue("Нет цен", mainPage.isDropdownItemVisible("До 30 000 $"))
        );
    }

    @Тогда("появляется подменю с категориями")
    public void assertDropdown(List<String> categories) {
        List<AssertInterface> assertList = new ArrayList<>();
        Allure.addAttachment("Step","появляется подменю с категориями");
        log.info("Проверка присутствия категорий " + categories);
        for (String category : categories) {
            assertList.add(() -> Assert.assertTrue("Не отображается " + category, mainPage.isDropdownItemVisible(category)));
        }
        AssertUtils.assertAll(assertList.toArray(new AssertInterface[1]));
    }

    @After
    public void close() {
        saveScreenShot();
        log.info("Закрытие браузера");
        WebDriverRunner.close();
    }

    @Attachment
    public static byte[] saveScreenShot() {
        return ((TakesScreenshot) WebDriverRunner.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
