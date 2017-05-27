package FireFoxTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

/**
 * Created by di452 on 24.05.2017.
 */
public class FacebookTest {
    private final Browsers BROWSER = Browsers.FIREFOX;
    private WebDriver driver;
    private WebDriverWait driverWait;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before

    public void setUps()
    {
        driver = Constants.getDriver(BROWSER);
        driverWait = Constants.getDriverWait(driver);
    }
    @Test
    public void testFacebook() throws Exception {
        Constants.OpenBrowser();
        driver.findElement(By.xpath("html/body/header/div[1]/div/div/div/ul[1]/li[4]/div[1]")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("html/body/header/div[1]/div/div/div/ul[1]/li[4]/div[2]/a[1]/span[2]")));
        driver.findElement(By.xpath("html/body/header/div[1]/div/div/div/ul[1]/li[4]/div[2]/a[1]/span[2]")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[1]/div/div/div[1]/div/div[1]/h1/a/i")));
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
