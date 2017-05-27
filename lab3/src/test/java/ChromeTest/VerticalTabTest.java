package ChromeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * Created by Димон on 26.05.2017.
 */
public class VerticalTabTest {
    private static final Browsers BROWSER = Browsers.CHROME;

    private WebDriver driver;
    private WebDriverWait driverWait;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = Constants.getDriver(BROWSER);
        driverWait = Constants.getDriverWait(driver);
    }

    @Test
    public void test() throws Exception {
        Constants.OpenBrowser();
        Constants.scrollWithOffset(driver.findElement(By.xpath("html/body/div[2]/div/div/section/nav/a[7]")), 0, 200);
        driver.findElement(By.xpath("html/body/div[2]/div/div/section/nav/a[7]")).click();
        try {
            assertEquals("Мнение", driver.findElement(By.xpath("html/body/div[1]/div[1]/main/h1")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
