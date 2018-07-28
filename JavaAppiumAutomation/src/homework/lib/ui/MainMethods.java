package homework.lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import homework.lib.MainPlatform;

import java.util.List;
import java.util.regex.Pattern;

public class MainMethods {

    protected AppiumDriver driver;

    public MainMethods(AppiumDriver driver)
    {
        this.driver = driver;
    }

    // Element waiting method
    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds)
    {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    //Overloaded element wait method
    public WebElement waitForElementPresent(String locator, String error_message)
    {
        return  waitForElementPresent(locator, error_message, 5);
    }

    public boolean findForElementPresent(String locator, String error_message, long timeoutInSeconds)
    {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by));
    }

    // The method of waiting for an element and clicking on it
    public WebElement waitForElementAndClick(String locator, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.click();
        return element;
    }


    // Ex10 method
    public void isElementEnabled(String locator)
    {
        WebElement element = driver.findElementByAccessibilityId(locator);
        boolean isEnabled = element.isEnabled();
    }

    // Wait and send keys method
    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    // Wait and clear element method
    public WebElement waitForElementAndClear(String locator, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    //Match text of element method
    public void assertTextNotMatchDefaultLabel(String locator, String search_text, String error_message)
    {
        By by = this.getLocatorByString(locator);
        WebElement element = driver.findElement(by);
        String text_element = element.getText();
        if (!text_element.equals(search_text)) {
            String default_message = "Text of element '" + by.toString() + "' does not match default search label.";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    //Assert method size elements <= 1
    public void assertElementsPresent (String locator, String error_message)
    {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        int amount_of_elements = elements.size();
        if (amount_of_elements <= 1) {
            String default_message = "An element " + by.toString() + " has no few results";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    //Assert method size elements > 0
    public void assertElementNotPresent(String locator, String error_message)
    {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        int amount_of_elements = elements.size();
        if (amount_of_elements > 0) {
            String default_message = "An element " + by.toString() + "not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    public void assertElementPresentMoreTwoLocators(String locator, String error_message)
    {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        int amount_of_elements = elements.size();
        if (amount_of_elements > 0) {
            String default_message = "An element " + by.toString() + "not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    // Wait not present element method
    public boolean waitForElementNotPresent(String locator, String error_message, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    //Wait all Locator's method
    public void waitForMenuInit(String LOCATOR_FOR_OPTION_1, String LOCATOR_FOR_OPTION_2, String LOCATOR_FOR_OPTION_3, String LOCATOR_FOR_OPTION_4, String LOCATOR_FOR_OPTION_5, String LOCATOR_FOR_OPTION_6)
    {
        waitForElementPresent(LOCATOR_FOR_OPTION_1,"Can't wait first locator", 10);
        waitForElementPresent(LOCATOR_FOR_OPTION_2,"Can't wait second locator", 10);
        waitForElementPresent(LOCATOR_FOR_OPTION_3,"Can't wait third locator", 10);
        waitForElementPresent(LOCATOR_FOR_OPTION_4,"Can't wait fourth locator", 10);
        waitForElementPresent(LOCATOR_FOR_OPTION_5,"Can't wait fifth locator", 10);
        waitForElementPresent(LOCATOR_FOR_OPTION_6,"Can't wait sixth locator", 10);
    }

    //Swipe method
    public void swipeUp(int timeOfSwipe)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);

        action
                .press(x, start_y)
                .waitAction(timeOfSwipe)
                .moveTo(x, end_y)
                .release()
                .perform();
    }

    //Swipe left method
    public void swipeElementToLeft(String locator, String error_message)
    {
        WebElement element = waitForElementPresent(
                locator,
                error_message,
                10
        );
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action.press(right_x, middle_y);
        action.waitAction(300);

        if (MainPlatform.getInstance().isAndroid()) {
            action.moveTo(left_x, middle_y);
        } else {
            int offset_x = (-1 * element.getSize().getWidth());
            action.moveTo(offset_x, 0);
        }

        action.release();
        action.perform();
    }

    public void clickElementToTheRightUpperCorner(String locator, String error_message)
    {
        WebElement element = this.waitForElementPresent(locator + "/..", error_message);
        int rigth_x = element.getLocation().getX();
        int uppet_y = element.getLocation().getY();
        int lower_y = uppet_y + element.getSize().getHeight();
        int middle_y = (uppet_y + lower_y) / 2;
        int width = element.getSize().getWidth();

        int point_to_click_x = (rigth_x + width) - 3;
        int point_to_click_y = middle_y;

        TouchAction action = new TouchAction(driver);
        action.tap(point_to_click_x, point_to_click_y).perform();
    }

    public boolean isElementLocatedOnTheScreen(String locator)
    {
        int element_location_by_y = this.waitForElementPresent(locator, "Cannot find element by locator", 3).getLocation().getY();
        int screen_size_by_y = driver.manage().window().getSize().getHeight();
        return element_location_by_y < screen_size_by_y;
    }

    //Quick swipe method
    public  void  swipeUpQuick()
    {
        swipeUp(200);
    }

    //Swipe up and find element method
    public  void swipeUpToFindElement(String locator, String error_message, int max_swipes)
    {
        By by = this.getLocatorByString(locator);
        int already_swiped = 0;
        if (already_swiped > max_swipes){
            waitForElementPresent(locator, "Cannot find elements by swiping up. \n" + error_message, 0);
            return;
        }

        while (driver.findElements(by).size() == 0){
            swipeUpQuick();
            ++already_swiped;
        }
    }

    //Count elements method
    public int getAmountOfElements(String locator)
    {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    //Get attribute method
    public String waitForElementAndGetAttribute(String locator, String attribute, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }

    //Locators
    private By getLocatorByString(String locator_with_type)
    {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if (by_type.equals("id")) {
            return By.id(locator);
        } else {
            throw new IllegalArgumentException("Cannot get typ of locator. Locator: " + locator_with_type);
        }
    }
}
