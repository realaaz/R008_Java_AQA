package P001_Jira;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C001_Jira_01 {

    static Long startTime;
    static WebDriver browser_GC;

    static String baseURL = "http://jira.hillel.it:8080/";
    static String loginURL = "http://jira.hillel.it:8080/login.jsp";


    static String dateStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    static String taskSummary = "AQA-test: " + dateStamp;


    @BeforeTest
    public void openChrome() {

        startTime = System.currentTimeMillis();

        System.setProperty("webdriver.chrome.driver", "/Users/ivanzakoretskyi/chromedriver");
        browser_GC = new ChromeDriver();

    }


    @AfterTest
    public void closeChrome() throws InterruptedException {

        Thread.sleep(2500);
        browser_GC.quit();

        // my debug info
        System.out.println("> Time used: " + "\t" + (System.currentTimeMillis() - startTime) + " milliseconds");
        long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("> Memory Used: " + "\t" + usedBytes + " bytes (" + usedBytes / 1048576.0 + " Megabytes)");

        System.out.println(taskSummary);
    }


    @Test(description = "Login to Jira - Positive scenario", priority = 1)
    public void TC001() {

    }


    @Test(description = "Create Issue", priority = 2)
    public void TC002() {

    }


    @Test(description = "Open Issue", priority = 3)
    public void TC003() {

    }


    @Test(description = "Login to Jira - Negative scenario", priority = 4)
    public void TC004() {

    }


}
