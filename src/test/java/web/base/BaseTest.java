package web.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import web.utils.LoggerUtil;

public class BaseTest {
    protected WebDriver driver;
    protected final Logger LOGGER = LoggerUtil.getLogger(this.getClass());

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
        Thread.sleep(300);
    }

    @AfterMethod
    public void quitDriver() {
        if (driver != null)
            driver.quit();
    }
}
