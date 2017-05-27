package ChromeTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Menuopen {
    private final Browsers BROWSER = Browsers.CHROME;
    private WebDriver driver;
    private WebDriverWait driverWait;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = Constants.getDriver(BROWSER);
        driverWait = Constants.getDriverWait(driver);
    }


    @Test
    public void testMenuopen() throws Exception {
        Constants.OpenBrowser();
        String buff = "Калькулятор вкладов";
        driver.findElement(By.xpath("//nav[@id='main-menu']/div[2]/div/span/span")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/section[1]/nav/div[2]/nav[1]/div[3]/ul/li[17]/a"))).getText().equals(buff);
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