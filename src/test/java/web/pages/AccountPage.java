package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.base.BasePage;
import web.customObjects.RegisterAccountDetails;

public class AccountPage extends BasePage {
    private final By usernameInputField = By.cssSelector("#username");
    private final By passwordInputField = By.cssSelector("#password");
    private final By registerUsernameInputField = By.cssSelector("#reg_username");
    private final By registerEmailInputField = By.cssSelector("#reg_email");
    private final By registerPasswordInputField = By.cssSelector("#reg_password");
    private final By registerButton = By.cssSelector("button[name='register']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void setUsernameInputField(String username) {
        this.sendKeys(this.usernameInputField, username);
    }

    public void setPasswordInputField(String password) {
        this.sendKeys(this.passwordInputField, password);
    }

    public void setRegisterUsernameInputField(String username) {
        this.sendKeys(this.registerUsernameInputField, username);
    }

    public void setRegisterEmailInputField(String email) {
        this.sendKeys(this.registerEmailInputField, email);
    }

    public void setRegisterPasswordInputField(String password) {
        this.sendKeys(this.registerPasswordInputField, password);
    }

    public void clickRegisterButton() {
        this.click(this.registerButton);
    }

    public void register(RegisterAccountDetails accountDetails) {
        this.setRegisterUsernameInputField(accountDetails.getUsername());
        this.setRegisterEmailInputField(accountDetails.getEmail());
        this.setRegisterPasswordInputField(accountDetails.getPassword());
        this.clickRegisterButton();
    }
}
