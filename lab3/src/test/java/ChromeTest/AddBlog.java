package ChromeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.fail;

/**
 * Created by Димон on 25.05.2017.
 */
public class AddBlog {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private final Browsers BROWSER = Browsers.CHROME;
    private StringBuffer verificationErrors = new StringBuffer();
    private String buff = "ОТПИСАТЬСЯ";


    @Before
    public void setUps()
    {
        driver = Constants.getDriver(BROWSER);
        driverWait = Constants.getDriverWait(driver);
    }

    @Test
    public void addblogTest() throws Exception {
        Constants.OpenBrowser();
        Constants.login(driver);
        driver.findElement(By.xpath("html/body/header/div[1]/div/div/div/ul[2]/li[1]/div/a/span")).click();
        Thread.sleep(3000);
         driver.findElement(By.xpath("html/body/section[2]/div[1]/main/div[1]/div/a[4]")).click();
        //driver.findElement(By.linkText("Моя лента")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/section[2]/div[1]/div[2]/ul[2]/li[5]/a"))).click();
       //driver.findElement(By.linkText("Топ авторов")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='tableID']/tbody/tr[2]/td[1]/div/a[2]"))).click();
        Thread.sleep(2000);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("html/body/section[2]/div[1]/section/div[2]/div[2]/div/div[1]/span/span[2]"))).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("html/body/section[2]/div[1]/section/div[2]/div[2]/div/div[1]/span/span[2]"))).getText().equals(buff);
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
