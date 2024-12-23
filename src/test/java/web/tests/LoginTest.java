package web.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.base.BaseTest;
import web.customObjects.RegisterAccountDetails;
import web.pages.AccountPage;
import web.pages.HomePage;
import web.utils.LoggerUtil;

public class LoginTest extends BaseTest {
    private HomePage homePage;
    private AccountPage accountPage;
    private Logger LOGGER;

    @BeforeClass
    public void beforeMethod() {
        LOGGER = LoggerUtil.getLogger(this.getClass());
    }

    @BeforeMethod
    public void beforeClass() {
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
    }

    @Test
    public void userShouldBeAbleToRegisterWithValidCredentials() {
        LOGGER.info("Started userShouldBeAbleToAbleToRegisterWithValidCredentials test");

        int accountId = 56;
        RegisterAccountDetails accountDetails = RegisterAccountDetails.builder()
                .username("user" + accountId)
                .email("user" + accountId + "@gmail.com")
                .password("password" + accountId)
                .build();

        homePage.clickAccountLink();
        accountPage.register(accountDetails);

        Assert.assertEquals(
                driver.findElement(By.xpath("//a[text()='Dashboard']")).isDisplayed(),
                true);

        LOGGER.info("Ended userShouldBeAbleToAbleToRegisterWithValidCredentials test");
    }

    @Test
    public void duplicateLogin() {
        LOGGER.info("Started duplicate test");

        int accountId = 59;
        RegisterAccountDetails accountDetails = RegisterAccountDetails.builder()
                .username("user" + accountId)
                .email("user" + accountId + "@gmail.com")
                .password("password" + accountId)
                .build();

        homePage.clickAccountLink();
        accountPage.register(accountDetails);

        Assert.assertEquals(
                driver.findElement(By.xpath("//a[text()='Dashboard']")).isDisplayed(),
                true);

        LOGGER.info("Finished duplicate test");
    }
}
