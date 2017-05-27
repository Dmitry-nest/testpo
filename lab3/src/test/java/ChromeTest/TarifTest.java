package ChromeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Димон on 26.05.2017.
 */


public class TarifTest {
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
    public void testTarif() throws Exception {
        Constants.OpenBrowser();
        driver.findElement(By.linkText("Мобильная связь и интернет")).click();
        driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/section[1]/div/a[1]/div[1]")).click();
        driver.findElement(By.xpath("html/body/div[1]/div[2]/main/section[1]/ul/li[1]/div/a")).click();
        driver.findElement(By.xpath("html/body/div[1]/div[1]/section/div[2]/div/div/form/div/div[1]/input")).sendKeys("9817244950");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            assertEquals("Если возможны более выгодные тарифы, стоимость услуги составит 149 руб.", driver.findElement(By.xpath("html/body/div[1]/div[1]/section/div[2]/p[3]")).getText());
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
