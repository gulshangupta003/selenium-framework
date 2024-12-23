package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.base.BasePage;

public class HomePage extends BasePage {
    private final By accountLink = By.xpath("//a[normalize-space()='Account']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickAccountLink() {
        this.click(accountLink);
    }
}
