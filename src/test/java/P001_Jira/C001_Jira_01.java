package P001_Jira;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C001_Jira_01 {

    static Long startTime;
    static WebDriver browser;

    static String baseURL = "http://jira.hillel.it:8080/";
    static String userName = "ivnzak";
    static String userPass = "123Qwerty";

    static String dataStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
    static String taskSummary = "Test_AQA_issue: " + dataStamp;


    @BeforeTest
    public void openChrome() {

        startTime = System.currentTimeMillis();

        System.setProperty("webdriver.chrome.driver", "/Users/ivanzakoretskyi/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--incognito");

        browser = new ChromeDriver(options);

        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @AfterTest
    public void closeChrome() throws InterruptedException {

        //Thread.sleep(10000);
        //browser.quit();

        // my additional debug info
        System.out.println("> Time used: " + "\t" + (System.currentTimeMillis() - startTime) + " milliseconds");
        long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("> Memory Used: " + "\t" + usedBytes + " bytes (" + usedBytes / 1048576.0 + " Megabytes)");

        System.out.println(taskSummary);
    }


//    @DataProvider (name = "just for example")
//    public static Object[][] dataProvider() {
//        return new Object[][]{{0, 9, 100, 10}, {0, 100, 10000, 2},};
//    }


    @Test(description = "Login to Jira - Positive scenario", priority = 1)
    public void TC001() {

        browser.get(baseURL);
        clearAndFill(By.cssSelector("input#login-form-username"), userName);
        clearAndFill(By.cssSelector("input#login-form-password"), userPass).submit();

        String pageData = browser.findElement(By.cssSelector("#header-details-user-fullname")).getAttribute("data-username");

        Assert.assertEquals(userName, pageData);
        Assert.assertTrue(pageData.contains(userName), "Negative case message: TC001");

    }


    @Test(description = "Create Issue in GQR Project", priority = 2)
    public void TC002() throws InterruptedException {

        browser.get("http://jira.hillel.it:8080/secure/RapidBoard.jspa?rapidView=3&projectKey=GQR");

        browser.findElement(By.id("create_link")).click();

        browser.findElement(By.id("summary")).sendKeys(taskSummary);
        browser.findElement(By.id("assign-to-me-trigger")).click();
        browser.findElement(By.id("create-issue-submit")).click();

//        String pageData = browser.findElement(By.cssSelector(".ghx-issue-content")).getAttribute("data-username");
//        List <WebElement> tasksList = browser.findElements(By.cssSelector(".ghx-summary")).;
//        Assert.assertTrue(tasksList.size() !=0, "Negative case message: TC002");
//        for(int i=0;i<tasksList.size();i++){
//            System.out.println(tasksList.get(i));
//        }

        clearAndFill(By.cssSelector("input#quickSearchInput"), taskSummary+"\n");

    }


    @Test(description = "Open Issue", priority = 3)
    public void TC003() {

    }


    @Test(description = "Login to Jira - Negative scenario", priority = 4)
    public void TC004() {

    }


    // Robert's feature
    // id   - "input#login-form-password"
    // name - "input[name=max]"
    private static WebElement clearAndFill(By selector, String data) {
        WebElement element = browser.findElement(selector);
        element.clear();
        element.sendKeys(data);

        return element;
    }


}
