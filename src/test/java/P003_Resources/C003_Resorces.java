package P003_Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigProperties;

// example
// http://www.autotest.org.ua/using-property-files-in-java-autotest/

public class C003_Resorces {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "/Users/ivanzakoretskyi/Drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getTestProperty("chromedriver"));
        driver = new ChromeDriver();
    }

    @Test
    public void openPage() {
        //driver.get("http://mvnrepository.com");
        driver.get(ConfigProperties.getTestProperty("url"));
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Maven Repository: Search"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}