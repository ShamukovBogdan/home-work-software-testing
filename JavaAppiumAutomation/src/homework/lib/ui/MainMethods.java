package homework.lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainMethods {

    protected AppiumDriver driver;

    public MainMethods(AppiumDriver driver)
    {
        this.driver = driver;
    }

    // Element waiting method
    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public boolean findForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by));
    }

    //Overloaded element wait method
    public WebElement waitForElementPresent(By by, String error_message)
    {
        return  waitForElementPresent(by, error_message, 5);
    }

    // The method of waiting for an element and clicking on it
    public WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    // Wait and send keys method
    public WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    // Wait and clear element method
    public WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    //Match text of element method
    public void assertTextNotMatchDefaultLabel(By by, String search_text, String error_message)
    {
        WebElement element = driver.findElement(by);
        String text_element = element.getText();
        if (!text_element.equals(search_text)) {
            String default_message = "Text of element '" + by.toString() + "' does not match default search label.";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    //Assert method size elements <= 1
    public void assertElementsPresent (By by, String error_message)
    {
        List elements = driver.findElements(by);
        int amount_of_elements = elements.size();
        if (amount_of_elements <= 1) {
            String default_message = "An element " + by.toString() + " has no few results";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    //Assert method size elements > 0
    public void assertElementNotPresent(By by, String error_message)
    {
        List elements = driver.findElements(by);
        int amount_of_elements = elements.size();
        if (amount_of_elements > 0) {
            String default_message = "An element " + by.toString() + "not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    // Wait not present element method
    public boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    //Wait all Locator's method
    public void waitForMenuInit(By LOCATOR_FOR_OPTION_1, By LOCATOR_FOR_OPTION_2, By LOCATOR_FOR_OPTION_3, By LOCATOR_FOR_OPTION_4, By LOCATOR_FOR_OPTION_5, By LOCATOR_FOR_OPTION_6)
    {
        waitForElementPresent(LOCATOR_FOR_OPTION_1,"Can't wait first locator", 10);
        waitForElementPresent(LOCATOR_FOR_OPTION_2,"Can't wait second locator", 10);
        waitForElementPresent(LOCATOR_FOR_OPTION_3,"Can't wait third locator", 10);
        waitForElementPresent(LOCATOR_FOR_OPTION_4,"Can't wait fourth locator", 10);
        waitForElementPresent(LOCATOR_FOR_OPTION_5,"Can't wait fifth locator", 10);
        waitForElementPresent(LOCATOR_FOR_OPTION_6,"Can't wait sixth locator", 10);
    }

    //Swipe left method
    public void swipeElementToLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent(
                by,
                error_message,
                10
        );
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(300)
                .moveTo(left_x, middle_y)
                .release()
                .perform();
    }
}
