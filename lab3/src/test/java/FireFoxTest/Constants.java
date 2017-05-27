package FireFoxTest; /**
 * Created by di452 on 23.05.2017.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

class Constants {
    private WebElement webElement;
    final static String BASE_URL="http://www.banki.ru/";
    private static WebDriver driver;
    private static WebDriverWait driverWait;


    static void login(WebDriver driver) throws InterruptedException {
        driver.findElement(By.linkText("Вход")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.name("Login")).click();
        Thread.sleep(5000);
    }

    static WebDriver getDriver(Browsers browserName) {
        if (browserName == Browsers.CHROME) {
            System.setProperty("webdriver.chrome.driver", "resources\\" + "chrome" + "\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            if (browserName == Browsers.FIREFOX) {
                System.setProperty("webdriver.gecko.driver", "resources\\" + "firefox" +"\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    return driver;
    }

    public static WebDriverWait getDriverWait (WebDriver driver)
    {
        driverWait = new WebDriverWait(driver, 100);
                return driverWait;
    }
    static void OpenBrowser()throws InterruptedException{
        driver.get(Constants.BASE_URL);
        Thread.sleep(3000);
    }

    static void setUps(Browsers BROWSER)
    {
        driver = Constants.getDriver(BROWSER);
        driverWait = Constants.getDriverWait(driver);
    }
    static void scrollWithOffset(WebElement webElement, int x, int y) {

        String code = "window.scroll(" + (webElement.getLocation().x + x) + ","
                + (webElement.getLocation().y + y) + ");";

        ((JavascriptExecutor)driver).executeScript(code, webElement, x, y);

    }
}
