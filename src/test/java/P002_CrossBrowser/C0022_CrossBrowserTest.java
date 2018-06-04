package P002_CrossBrowser;

import org.testng.Assert;
import org.testng.annotations.Test;


public class C0022_CrossBrowserTest extends C0021_CrossBrowserTest {

    @Test
    public void openPage() {
        driver.get("https://mail.ukr.net/desktop/login");
        String titleActual = driver.getTitle();
        String titleExpected = "Пошта @ ukr.net - українська електронна пошта • Створи емейл";
        Assert.assertEquals(titleActual, titleExpected);
    }

}
