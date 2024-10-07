package saucepage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class souceLab {
    private final SelenideElement name = $(By.cssSelector("input[id=\"user-name\"]"));
    private final SelenideElement password = $(By.cssSelector("input[id=\"password\"]"));
    private final SelenideElement login = $(By.cssSelector("input[type=\"submit\"]"));
    private final SelenideElement backpack = $(By.cssSelector("button[data-test=\"add-to-cart-sauce-labs-backpack\"]"));
    private final SelenideElement bikelight = $(By.cssSelector("button[data-test=\"add-to-cart-sauce-labs-bike-light\"]"));
    private final SelenideElement t_Shirt = $(By.cssSelector("button[data-test=\"add-to-cart-sauce-labs-bolt-t-shirt\"]"));
    private final SelenideElement red_T_shirt = $(By.cssSelector("button[data-test=\"add-to-cart-sauce-labs-fleece-jacket\"]"));
    private final SelenideElement itemCountText = $(By.cssSelector("a[data-test=\"shopping-cart-link\"]"));
    private final SelenideElement checkoutButton = $(By.cssSelector("button[data-test=\"checkout\"]"));
    private final SelenideElement continueButton = $(By.cssSelector("input[data-test=\"continue\"]"));
    private final SelenideElement firstName = $(By.cssSelector("input[name=\"firstName\"]"));
    private final SelenideElement lastName = $(By.cssSelector("input[data-test=\"lastName\"]"));
    private final SelenideElement zipCode = $(By.cssSelector("input[data-test=\"postalCode\"]"));
    private final SelenideElement subtotal = $(By.cssSelector("div[data-test=\"subtotal-label\"]"));
    private final SelenideElement total = $(By.cssSelector("div[data-test=\"total-label\"]"));
    private final SelenideElement tax = $(By.cssSelector("div[data-test=\"tax-label\"]"));
    private final SelenideElement finishButton = $(By.cssSelector("button[data-test=\"finish\"]"));
    private final SelenideElement completeMessage = $(By.cssSelector("h2[data-test=\"complete-header\"]"));

    public void setLoginName(String loginNameValue) {
        name.shouldBe(visible);
        name.setValue(loginNameValue);
    }

    public void setLoginPassword(String passwordValue) {
        password.setValue(passwordValue);
    }

    public void clickLogin() {
        login.click();
    }

    public void addItemToCart1() {
        backpack.click();
    }

    public void addItemToCart2() {
        bikelight.click();
    }

    public void addItemToCart3() {
        t_Shirt.click();
    }

    public void addItemToCart4() {
        red_T_shirt.click();
    }

    public void itemCount() {
        String numberOfItems = itemCountText.getText();
        System.out.println("Number of items in the cart: " + numberOfItems);
        itemCountText.click();
    }

    public void checkOutItems() {
        checkoutButton.click();
    }

    public void checkoutYourFirstName(String firstNameValue) {
        firstName.setValue(firstNameValue);
    }

    public void checkoutYourLastName(String lastNameValue) {
        lastName.setValue(lastNameValue);
    }

    public void checkoutYourZipCode(String zipCodeValue) {
        zipCode.setValue(zipCodeValue);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void checkoutOverview() {
        System.out.println("Subtotal: " + subtotal.getText());
        System.out.println("Tax: " + tax.getText());
        System.out.println("Total: " + total.getText());
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public void verifyProcessCompleteMessage() {
        String complete = completeMessage.getText();
        if ("THANK YOU FOR YOUR ORDER".equals(complete)) {
            System.out.println("Order completed successfully!");
        } else {
            System.out.println("Order completion message mismatch! Found: " + complete);
        }
    }
}
