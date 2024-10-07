import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import saucepage.souceLab;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;

public class souceLabTest {
    private Properties properties = new Properties();

    @BeforeTest
    public void setup() {
        try (InputStream input = souceLabTest.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Configuration.baseUrl = properties.getProperty("baseUrl");
        Configuration.browser = properties.getProperty("browser");
        Configuration.timeout = Long.parseLong(properties.getProperty("timeout")); // timeout is already in milliseconds

        open(Configuration.baseUrl); // Open the base URL
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @Test
    public void performCheckoutTest() {
        open(Configuration.baseUrl);  // Open the URL from properties
        System.out.println(title());

        souceLab loginPage = new souceLab();
        // Login with credential
        loginPage.setLoginName(properties.getProperty("User"));
        loginPage.setLoginPassword(properties.getProperty("pwd"));
        loginPage.clickLogin();

        // Adding items to cart
        loginPage.addItemToCart1();
        loginPage.addItemToCart2();
        loginPage.addItemToCart3();
        loginPage.addItemToCart4();

        loginPage.itemCount();
        loginPage.checkOutItems();

        // Filling out checkout details
        loginPage.checkoutYourFirstName(properties.getProperty("myfirstname"));
        loginPage.checkoutYourLastName(properties.getProperty("mylastname"));
        loginPage.checkoutYourZipCode(properties.getProperty("myzipcode"));

        loginPage.clickContinue();
        loginPage.checkoutOverview();
        loginPage.clickFinishButton();
        loginPage.verifyProcessCompleteMessage();
    }
}
