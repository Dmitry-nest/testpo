package FireFoxTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

/**
 * Created by Димон on 26.05.2017.
 */
public class ScrollTest {
    private WebElement webElement;
    private final Browsers BROWSER = Browsers.FIREFOX;
    private WebDriver driver;
    private WebDriverWait driverWait;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = Constants.getDriver(BROWSER);
        driverWait = Constants.getDriverWait(driver);
    }

    @Test
   public void ReitOpenTest() throws Exception
    {
        Constants.OpenBrowser();
        Constants.scrollWithOffset(driver.findElement(By.xpath("html/body/div[2]/div/div/div/section[1]/h2")), 0, 200);
        driver.findElement(By.xpath("html/body/div[2]/div/div/div/section[1]/h2"));
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
