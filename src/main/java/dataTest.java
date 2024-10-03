import com.codeborne.selenide.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class dataTest {
    public static void loadProperties(){
        Properties prop = new Properties();
        try{
            prop.load(new FileInputStream("src/test/java/souceLabTest.java"));
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file", e);
        }

        Configuration.baseUrl = prop.getProperty("baseUrl", "https://www.saucedemo.com/");
        Configuration.browser = prop.getProperty("browser", "chrome");
        Configuration.timeout = Long.parseLong(prop.getProperty("timeout", "10000"));
        Configuration.headless = Boolean.parseBoolean(prop.getProperty("headless", "true"));

    }
}
