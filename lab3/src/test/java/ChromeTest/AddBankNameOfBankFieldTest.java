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

/**
 * Created by di452 on 26.05.2017.
 */
public class AddBankNameOfBankFieldTest {
    private final Browsers BROWSER = Browsers.CHROME;
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
    public void NameNoWriteTest() throws Exception {
        Constants.OpenBrowser();
        Constants.login(driver);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.link-with-icon__text.user-name"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("html/body/section[2]/div[1]/main/div[1]/div/a[2]")).click();
        driver.findElement(By.xpath("html/body/section[2]/div[1]/aside/section[1]/div/div/div[2]/div[1]/div[2]/a")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='uiSelect_1']/div[1]/div[1]"))).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='uiSelect_1']/div[2]/div/div/div[1]/div/div[2]"))).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.button.button--blue"))).click();
        try {
            assertEquals("Необходимо выбрать банк", driver.findElement(By.xpath("html/body/div[6]/section/div/form/div/div[1]/div/div[2]")));
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
