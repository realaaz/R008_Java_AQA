package P002_CrossBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


public class C0021_CrossBrowserTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    protected WebDriver getDriver(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/ivanzakoretskyi/Drivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/ivanzakoretskyi/Drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @AfterTest
    protected void tearDown() {
        if (driver != null)
            driver.quit();
    }
}


