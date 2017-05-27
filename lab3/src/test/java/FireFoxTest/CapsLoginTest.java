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
public class CapsLoginTest {
    private static final Browsers BROWSER = Browsers.FIREFOX;

    private WebDriver driver;
    private WebDriverWait driverWait;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = Constants.getDriver(BROWSER);
        driverWait = Constants.getDriverWait(driver);
    }

    @Test
    public void testSucsessLogin() throws Exception {
        Constants.OpenBrowser();
        driver.findElement(By.linkText("Вход")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).sendKeys("LIZALUKINA");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Liza1996");
        driver.findElement(By.name("Login")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/header/div[1]/div/div/div/ul[2]/li[1]/div/a/img")));

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
