package web.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.utils.LoggerUtil;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    private final WebDriverWait wait;
    protected final Logger LOGGER = LoggerUtil.getLogger(this.getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Get a WebElement using the provided locator.
     *
     * @param locator
     * @return WebElement
     */
    protected WebElement getElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.error("Element not found: {}.\nException: {}",
                    locator, noSuchElementException.getStackTrace());
            throw noSuchElementException;
        } catch (RuntimeException runtimeException) {
            LOGGER.error("Error while finding element: {}.\nException: {}",
                    locator, runtimeException.getStackTrace());
            throw runtimeException;
        }
    }

    /**
     * Get a list of WebElements using the provided locator.
     *
     * @param locator
     * @return List<WebElement>
     */
    protected List<WebElement> getElements(By locator) {
        try {
            return driver.findElements(locator);
        } catch (NoSuchElementException noSuchElementException) {
            LOGGER.error("Elements not found: {}. Exception: {}",
                    locator, noSuchElementException.getStackTrace());
            throw noSuchElementException;
        } catch (RuntimeException runtimeException) {
            LOGGER.error("Error while finding elements: {}.\nException: {}",
                    locator, runtimeException.getStackTrace());
            throw runtimeException;
        }
    }

    /**
     * Waits for a WebElement to become visible on the page.
     *
     * @param locator
     * @return WebElement
     */
    protected WebElement waitForDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException timeoutException) {
            LOGGER.error("Timeout while waiting for element to be visible: {}.\nException: {}",
                    locator, timeoutException.getStackTrace());
            throw timeoutException;
        } catch (RuntimeException runtimeException) {
            LOGGER.error("Error while waiting for element to be visible: {}.\nException: {}",
                    locator, runtimeException.getStackTrace());
            throw runtimeException;
        }
    }

    /**
     * Waits for a WebElement to become clickable on the page.
     *
     * @param locator
     * @return WebElement
     */
    protected WebElement waitForClickable(By locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException timeoutException) {
            LOGGER.error("Timeout while waiting for element to be clickable: {}.\nException: {}",
                    locator, timeoutException.getStackTrace());
            throw timeoutException;
        } catch (RuntimeException runtimeException) {
            LOGGER.error("Error while waiting for element to be clickable: {}.\nException: {}",
                    locator, runtimeException.getStackTrace());
            throw runtimeException;
        }
    }

    /**
     * Clicks on a WebElement identified by the provided locator.
     *
     * @param locator
     */
    protected void click(By locator) {
        try {
            this.getElement(locator).click();
        } catch (RuntimeException runtimeException) {
            LOGGER.error("Error while clicking element: {}.\nException: {}",
                    locator, runtimeException.getStackTrace());
            throw runtimeException;
        }
    }

    /**
     * Sends text input to a WebElement identified by the provided locator.
     *
     * @param locator
     * @param text
     */
    protected void sendKeys(By locator, String text) {
        try {
            this.getElement(locator).sendKeys(text);
        } catch (RuntimeException runtimeException) {
            LOGGER.error("Error while sending keys to element: {}.\nException: {}",
                    locator, runtimeException.getStackTrace());
            throw runtimeException;
        }
    }
}
