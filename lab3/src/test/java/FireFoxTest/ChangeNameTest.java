package FireFoxTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * Created by Димон on 26.05.2017.
 */
public class ChangeNameTest {
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
    public void testChangeName() throws Exception {
        Constants.OpenBrowser();
        Constants.login(driver);
        driver.findElement(By.cssSelector("span.link-with-icon__text.user-name")).click();
        driver.findElement(By.linkText("Профиль")).click();
        driver.findElement(By.cssSelector("h2 > a.edit")).click();
        Thread.sleep(3000);
        Constants.scrollWithOffset(driver.findElement
                (By.xpath("html/body/section[2]/div[1]/div/form/div[2]/dl[1]/dd[2]/input")), 0, 50);
        driver.findElement(By.xpath("html/body/section[2]/div[1]/div/form/div[2]/dl[1]/dd[2]/input")).clear();
        driver.findElement(By.xpath("html/body/section[2]/div[1]/div/form/div[2]/dl[1]/dd[2]/input")).sendKeys("Анна");
        Constants.scrollWithOffset(driver.findElement(By.name("save")), 0, 200);
        driver.findElement(By.name("save")).click();
        try {
            assertEquals("Анна Лукина", driver.findElement
                    (By.xpath("html/body/section[2]/div[1]/main/section/div[2]/div[1]")).getText());
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
