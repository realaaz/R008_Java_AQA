package P001_Jira;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C001_Jira_01 {

    private static WebDriver browser_GC;
    private static Long startTime;


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

        // some debug info
        System.out.println("> Time used: " + "\t" + (System.currentTimeMillis() - startTime) + " milliseconds");
        long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("> Memory Used: " + "\t" + usedBytes + " bytes (" + usedBytes / 1048576.0 + " Megabytes)");
    }


    @Test (description = "Login to Jira - Positive scenario", priority = 1)
    public void TC001 () {

    }


    @Test (description = "Create Issue", priority = 2)
    public void TC002 () {

    }


    @Test (description = "Open Issue", priority = 3)
    public void TC003 () {

    }


    @Test (description = "Login to Jira - Negative scenario", priority = 4)
    public void TC004 () {

    }



}
