import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import saucepage.souceLab;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

public class souceLabTest {
    @BeforeTest
    public void visitePage(){
        //dataTest.loadProperties();
        //open("/");

    }
    @Test
    public void souceLabTest(){
        open("https://www.saucedemo.com/");
        //open("/");
        System.out.println(title());
        souceLab loginfield = new souceLab();
        loginfield.setLoginName();
        loginfield.setLoginPassword();
        loginfield.clickLogin();
    }
}
