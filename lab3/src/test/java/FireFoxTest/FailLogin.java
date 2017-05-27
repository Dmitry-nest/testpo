package FireFoxTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

/**
 * Created by di452 on 24.05.2017.
 */
public class FailLogin {
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
    public void testFailLogIn() throws Exception {
        Constants.OpenBrowser();
        driver.findElement(By.cssSelector("div.header__bar")).click();
        driver.findElement(By.linkText("Вход")).click();
        Thread.sleep(2000);
       // driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[5]/section/form/div[1]/div/input")));
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("songto1");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Qaz123wsx");
        driver.findElement(By.name("Login")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Qaz123wsx");
        driver.findElement(By.name("Login")).click();
        driver.findElement(By.xpath("html/body/section[2]/div[1]"));

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
