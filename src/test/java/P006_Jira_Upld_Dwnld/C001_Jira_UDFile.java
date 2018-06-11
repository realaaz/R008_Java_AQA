package P006_Jira_Upld_Dwnld;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class C001_Jira_UDFile {

    static WebDriver browser;

    static String baseURL = "http://jira.hillel.it:8080/";
    static String userName = "ivnzak";
    static String userPass = "123Qwerty";
    static String someFileF = "/Users/ivanzakoretskyi/Projects/2018/10_Java_AQA/upl_downl_file.txt";
    static String someFile = "upl_downl_file.txt";


    @BeforeTest
    public void openChrome() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/ivanzakoretskyi/Drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito");
        browser = new ChromeDriver(options);

        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        browser.get(baseURL);
        clearAndFill(By.cssSelector("input#login-form-username"), userName);
        clearAndFill(By.cssSelector("input#login-form-password"), userPass).submit();

        Thread.sleep(2500);

    }


    @AfterTest
    public void tearDown() throws InterruptedException {

        Thread.sleep(2500);
        browser.quit();

    }


    @Test(description = "Upload file to the ticket", priority = 1)
    public void uploadFileToJiraOnMac() throws AWTException, InterruptedException {

        browser.get("http://jira.hillel.it:8080/browse/GQR-783");
        browser.findElement(By.className("issue-drop-zone__button")).click();

        browser.findElement(By.className("issue-drop-zone__file ignore-inline-attach")).sendKeys(someFileF);

        Thread.sleep(2500);

        Robot r = new Robot();

        // select file U
        r.keyPress(KeyEvent.VK_U);
        // я теряю фокус ((

        Thread.sleep(2500);

        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(5000);


    }


    @Test(description = "Download file from the ticket", priority = 2)
    public void downloadFileToJiraOnMac() {
        // todo

    }


    private static WebElement clearAndFill(By selector, String data) {
        WebElement element = browser.findElement(selector);
        element.clear();
        element.sendKeys(data);

        return element;
    }


}
