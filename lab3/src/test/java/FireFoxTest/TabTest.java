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
 * Created by Димон on 26.05.2017.
 */
public class TabTest {
    private static final Browsers BROWSER = Browsers.CHROME;

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

public void tabtest() throws Exception
{
    Constants.OpenBrowser();
    driver.findElement(By.xpath(".//*[@id='main-menu']/div[1]/div/a[3]")).click();
    driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1.header-h0")));
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
