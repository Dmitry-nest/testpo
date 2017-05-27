package ChromeTest;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

public class AddbankFullTest {
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
    public void testAddbank() throws Exception {
        Constants.OpenBrowser();
        Constants.login(driver);
        driver.findElement(By.xpath("html/body/header/div[1]/div/div/div/ul[2]/li[1]/div/a/img")).click();
        Thread.sleep(2000);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("html/body/section[2]/div[1]/main/div[1]/div/a[2]"))).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("html/body/section[2]/div[1]/aside/section[1]/div/div/div[2]/div[1]/div[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@value=''])[4]")).clear();
        driver.findElement(By.xpath("(//input[@value=''])[4]")).sendKeys("В");

        driverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("html/body/div[6]/section/div/form/div/div[1]/div/div/div/span[2]/div/span/div[1]/p"))).click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='uiSelect_1']/div[1]/div[1]"))).click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                (".//*[@id='uiSelect_1']/div[2]/div/div/div[1]/div/div[2]"))).click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.button.button--blue"))).click();
        Thread.sleep(1000);
        try {
            TestCase.assertEquals("1",
                    driver.findElement(By.xpath
                            ("html/body/section[2]/div[1]/aside/section[1]/div/div/div[2]/div[1]/div[1]/span")).getText());
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

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}