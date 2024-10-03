package saucepage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class souceLab {
    private final SelenideElement name = $(By.cssSelector("input[id=\"user-name\"]"));
    private final SelenideElement password = $(By.cssSelector("input[id=\"password\"]"));
    private final SelenideElement login = $(By.cssSelector("input[type=\"submit\"]"));

    public void setLoginName(){
        $(name).setValue("standard_user");
    }
    public void setLoginPassword(){
        $(password).setValue("secret_sauce");
    }
    public void clickLogin(){
        $(login).click();
    }


}
