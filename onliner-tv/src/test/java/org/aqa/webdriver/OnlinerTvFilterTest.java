package org.aqa.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OnlinerTvFilterTest {

    WebDriver webDriver;
    JavascriptExecutor js;
    String faildNameTV = null;
    private final static By TV_MENU = By.xpath("//*[contains(text(),'Телевизоры')]");
    private final static By TV_MANUFACTURER_SCROLL = By.xpath("//*[@class='catalog-form__label-title'  and contains(text(),'Производитель')]");
    private final static String TV_FILTER_PATH = "//*[contains(@class,'checkbox-item')][text()='%s']";
    private final static By TEG_RESULT_FILTER = By.xpath("//*[@class='button-style button-style_either button-style_small catalog-form__button catalog-form__button_tag']");
    private final static By TV_ALL_RESULTS_FILTER = By.xpath("//*[@class='catalog-form__link catalog-form__link_primary-additional catalog-form__link_base-additional catalog-form__link_font-weight_semibold catalog-form__link_nodecor']");
    private final static By WAIT_SEARCHING = By.xpath("//*[@class='catalog-interaction__state catalog-interaction__state_initial catalog-interaction__state_disabled catalog-interaction__state_control']");
    private final static String BREAD_CRUMB_PATTERN = "//*[@class='breadcrumbs__link']/span[text() = '%s']";
    private final static By CITY_SELECTOR = By.xpath("//*[contains(@class,'popover-style__container')]//*[contains(@class,'small-alter')]");

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.onliner.by/");
        js = (JavascriptExecutor) webDriver;
    }

    @DataProvider(name = "manufacturerTv")
    private String[] getManufacturerTv() {
        return new String[]{"LG", "TCL", "Sony"};
    }

    //Тест на проверку верного тега при фильтрации по производителю
    @Test(dataProvider = "manufacturerTv")
    public void testTvFilterTeg(String nameTV) {
        WebElement tvMenu = webDriver.findElement(TV_MENU);
        tvMenu.click();
        acceptCityPopup();
        WebElement scroll = webDriver.findElement(TV_MANUFACTURER_SCROLL);
        js.executeScript("arguments[0].scrollIntoView();", scroll);

        WebElement tvFilter = webDriver.findElement(By.xpath(String.format(TV_FILTER_PATH, nameTV)));
        tvFilter.click();

        WebElement tegResultFilter = webDriver.findElement(TEG_RESULT_FILTER);
        String nameTeg = tegResultFilter.getText();
        Assert.assertEquals(nameTV, nameTeg, "Тест провален, тег " + nameTeg + " != производителю телевизора " + nameTV);
    }

    private void acceptCityPopup() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 3);
            wait.until(ExpectedConditions.visibilityOfElementLocated(CITY_SELECTOR));
            webDriver.findElement(CITY_SELECTOR).click();
        } catch (Exception ex){
            System.out.println("No city selector popup");
        }

    }

    //Тест на проверку, что производитель содержится в названии найденных товаров
    @Test(dataProvider = "manufacturerTv")
    public void testTvFilter(String nameTV) {
        WebElement tvMenu = webDriver.findElement(TV_MENU);
        tvMenu.click();
        acceptCityPopup();
        WebElement scroll = webDriver.findElement(TV_MANUFACTURER_SCROLL);
        js.executeScript("arguments[0].scrollIntoView();", scroll);

        WebElement tvFilter = webDriver.findElement(By.xpath(String.format(TV_FILTER_PATH, nameTV)));
        tvFilter.click();

        WebDriverWait wait = new WebDriverWait(webDriver, 2);
        wait.until(ExpectedConditions.presenceOfElementLocated(WAIT_SEARCHING));

        List<WebElement> listResultFilter = webDriver.findElements(TV_ALL_RESULTS_FILTER);
        boolean trueFilter = true;
        for (WebElement el : listResultFilter) {
            if (!el.getText().contains(nameTV)) {
                trueFilter = false;
                faildNameTV = nameTV;
                break;
            }
        }
        Assert.assertTrue(trueFilter, "Тест провален, в названии телевизора " + nameTV + " не содержится производитель");
    }

    //Тест на проверку, что найденный товар действительно относится к разделу производителя(на это указывают хлебные крошки в карточке товара)
    @Test(dataProvider = "manufacturerTv")
    public void testTvFilterTrueSection(String nameTV) {
        WebElement tvMenu = webDriver.findElement(TV_MENU);
        tvMenu.click();
        acceptCityPopup();
        WebElement scroll = webDriver.findElement(TV_MANUFACTURER_SCROLL);
        js.executeScript("arguments[0].scrollIntoView();", scroll);

        WebElement tvFilter = webDriver.findElement(By.xpath(String.format(TV_FILTER_PATH, nameTV)));
        tvFilter.click();

        WebDriverWait wait = new WebDriverWait(webDriver, 2);
        wait.until(ExpectedConditions.presenceOfElementLocated(WAIT_SEARCHING));

        List<WebElement> listResultFilter = webDriver.findElements(TV_ALL_RESULTS_FILTER);
        List<String> tvNameList = new ArrayList<>();
        for (WebElement webElement : listResultFilter) {
            String text = webElement.getText();
            tvNameList.add(text);
        }
        Actions action = new Actions(webDriver);
        boolean trueFilter = true;
        for (String tvName : tvNameList) {
            listResultFilter = webDriver.findElements(TV_ALL_RESULTS_FILTER);
            WebElement el = null;
            for (WebElement we : listResultFilter) {
                if (we.getText().equals(tvName)) {
                    el = we;
                    break;
                }
            }
            if (el == null) {
                trueFilter = false;
                break;
            }
            action.moveToElement(el).click().perform();

            By breadCrumbLocator = By.xpath(String.format(BREAD_CRUMB_PATTERN, nameTV));
            wait.until(ExpectedConditions.presenceOfElementLocated(breadCrumbLocator));
            WebElement crumb = webDriver.findElement(breadCrumbLocator);
            if (!crumb.getText().contains(nameTV)) {
                trueFilter = false;
                faildNameTV = nameTV;
                break;
            }
            webDriver.navigate().back();
        }
        Assert.assertTrue(trueFilter, "Тест провален, производитель телевизора " + faildNameTV + " != итоговой хлебной крошке, т.е. не содержится в разделе искомого производителя");
    }

    @AfterMethod
    public void cleanUp(Method method) {
        if (webDriver != null) {
            webDriver.quit();
        }
        System.out.println("Тест " + method.getName() + " завершен");
    }
}
