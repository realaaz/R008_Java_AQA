package P004_Selenide;

import com.codeborne.selenide.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



// http://www.autotest.org.ua/selenide-quick-start-in-automation-testing/

public class C004_Selenide {

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/ivanzakoretskyi/Drivers/chromedriver");
        Configuration.browser = "chrome";
        open("https://mail.ukr.net/desktop/login");
    }

    @Test
    public void userLogin() {
        $("#login").setValue("autotestorgua");
        $("#password").setValue("testpass");
        $(By.xpath("//button[text()='Войти']")).click();
        $(".login-button__user").shouldHave(visible, text("autotestorgua@ukr.net"));
    }

    @AfterClass
    public static void tearDown() {
        $(".login-button__menu-icon").click();
        $("#login__logout").shouldBe(visible).click();
    }

}
