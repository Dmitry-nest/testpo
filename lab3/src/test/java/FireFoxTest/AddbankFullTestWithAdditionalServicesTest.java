package FireFoxTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by di452 on 26.05.2017.
 */
public class AddbankFullTestWithAdditionalServicesTest {
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
    public void testWithadditional() throws Exception {
        Constants.OpenBrowser();
        Constants.login(driver);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.link-with-icon__text.user-name"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("html/body/section[2]/div[1]/main/div[1]/div/a[2]")).click();
        driver.findElement(By.xpath("html/body/section[2]/div[1]/aside/section[1]/div/div/div[2]/div[1]/div[2]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@value=''])[4]")).clear();
        driver.findElement(By.xpath("(//input[@value=''])[4]")).sendKeys("ро");

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[6]/section/div/form/div/div[1]/div/div/div/span[2]/div/span/div[1]/p"))).click();//choose bank

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[6]/section/div/form/div/div[3]/div/div/div[1]/div[1]"))).click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[6]/section/div/form/div/div[3]/div/div/div[2]/div/div/div[1]/div/div[2]"))).click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[6]/section/div/form/div/div[4]/div/div/span[1]/span[1]"))).click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[6]/section/div/form/div/div[4]/div/div/div/div[2]/div/div/div/div[1]/div[1]/div/div[1]/span"))).click();
        driver.findElement(By.xpath(" html/body/div[6]/section/div/form/footer/div/input")).click();
        Thread.sleep(1000);
        try {
            assertEquals("1", driver.findElement(By.xpath("html/body/section[2]/div[1]/aside/section[1]/div/div/div[2]/div[1]/div[1]/span   ")).getText());
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
