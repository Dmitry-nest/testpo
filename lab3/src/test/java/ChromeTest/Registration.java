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
 * Created by di452 on 24.05.2017.
 */
public class Registration {
    private static final Browsers browser = Browsers.FIREFOX;

    private WebDriver driver;
    private WebDriverWait driverWait;
    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setup(){
        Constants.setUps(browser);
    }
    @Test

    public void RegistrationTest()throws InterruptedException{
        Constants.OpenBrowser();
        driver.findElement(By.xpath("html/body/header/div[1]/div/div/div/ul[2]/li[1]/div/a[2]")).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/section[2]/div[1]/form/div[2]/table[1]/tbody/tr/td[2]")));
        driver.findElement(By.name("USER_LOGIN")).click();
        driver.findElement(By.name("USER_LOGIN")).clear();
        driver.findElement(By.name("USER_LOGIN")).sendKeys("songto2");
        driver.findElement(By.name("USER_PASSWORD")).clear();
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("Qaz123wsx");
        driver.findElement(By.name("USER_CONFIRM_PASSWORD")).clear();
        driver.findElement(By.name("USER_CONFIRM_PASSWORD")).sendKeys("Qaz123wsx");
        driver.findElement(By.name("PERSONAL_MOBILE")).clear();
        driver.findElement(By.name("PERSONAL_MOBILE")).sendKeys("8911232445");
        driver.findElement(By.name("USER_EMAIL")).clear();
        driver.findElement(By.name("USER_EMAIL")).sendKeys("uhzx2z@vmani.com");
        driver.findElement(By.name("captcha_word")).clear();
        Thread.sleep(5000);
        driver.findElement(By.name("Register")).click();
        try {
            assertEquals("Вы были успешно зарегистрированы.", driver.findElement(By.xpath("html/body/section[2]/div[1]/div[1]/strong")).getText());
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

