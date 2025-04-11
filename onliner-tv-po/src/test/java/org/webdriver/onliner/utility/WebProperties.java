package org.webdriver.onliner.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebProperties {
    private static Properties properties;
    public static Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(new FileInputStream("src/settings.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return properties;
    }
    public static String getBaseUrl(){
        return getProperties().getProperty("baseUrls");
    }

    public static String getBrowserType() {
        return getProperties().getProperty("browserType");
    }
}
