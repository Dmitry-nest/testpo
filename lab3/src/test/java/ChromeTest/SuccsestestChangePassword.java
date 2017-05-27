package ChromeTest;

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
public class SuccsestestChangePassword {
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
    public void SuccsestestChangePassword() throws Exception {
        Constants.OpenBrowser();
        Constants.login(driver);
            driver.findElement(By.xpath("html/body/header/div[1]/div/div/div/ul[2]/li[1]/div/a/img")).click();
        Thread.sleep(2000);
            driver.findElement(By.linkText("Профиль")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("html/body/section[2]/div[1]/main/div[2]/dl/section[1]/h2/a"))).click();
        Constants.scrollWithOffset(driver.findElement
                (By.xpath("html/body/section[2]/div[1]/div/form/div[2]/dl[1]/dd[6]/input")), 0, 200);
        Thread.sleep(3000);
            driver.findElement(By.xpath("html/body/section[2]/div[1]/div/form/div[2]/dl[1]/dd[6]/input")).click();
            driver.findElement(By.xpath("html/body/section[2]/div[1]/div/form/div[2]/dl[1]/dd[6]/input")).clear();
            driver.findElement(By.xpath("html/body/section[2]/div[1]/div/form/div[2]/dl[1]/dd[6]/input")).sendKeys("");
            driver.findElement(By.name("NEW_PASSWORD_CONFIRM")).click();
            driver.findElement(By.name("NEW_PASSWORD_CONFIRM")).clear();
            driver.findElement(By.name("NEW_PASSWORD_CONFIRM")).sendKeys("");
        Constants.scrollWithOffset(driver.findElement(By.name("save")), 0, 200);
            driver.findElement(By.name("save")).click();
        Constants.scrollWithOffset(driver.findElement(By.xpath("html/body/section[2]/div[1]/main/div[2]/dl/dd[1]")), 0, 200);
            driver.findElement(By.xpath("html/body/section[2]/div[1]/main/div[2]/dl/dd[1]"));
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
