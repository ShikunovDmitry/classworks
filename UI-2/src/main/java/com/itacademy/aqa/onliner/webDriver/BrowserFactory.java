package com.itacademy.aqa.onliner.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {

    static {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
    }

    public static WebDriver createDriver(BrowserEnum browserEnum){

        WebDriver webDriver;

        switch (browserEnum){
            case CHROME -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                Map<String,Object> prefs = new HashMap<>();
                prefs.put("safebrowsing.enabled", true);
                prefs.put("download.default_directory","C:\\Users\\Dzmitry_Shykunou\\Downloads\\");
                prefs.put("browser.helperApps.neverAsk.saveToDisk","application/pdf;text/csv;application/octet-stream;application/x-msdownload");
                chromeOptions.setExperimentalOption("prefs",prefs);
                webDriver = new ChromeDriver(chromeOptions);

                /*
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");

                    // Подменяем user-agent на обычный браузер
                    options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");

                    // Убираем флаги автоматизации
                    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                    options.addArguments("--disable-blink-features=AutomationControlled");
                 */
            }
            case FIREFOX -> {
                webDriver = new FirefoxDriver();
            }
            default -> {
                throw new RuntimeException( browserEnum + " is not supported");
            }
        }

        return webDriver;

    }
}
