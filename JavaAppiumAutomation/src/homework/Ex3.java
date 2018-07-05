package homework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.net.URL;

public class Ex3 {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        //Current working directory of the APK file
        String current = System.getProperty("user.dir");
        String apkFile = current + "/apks/org.wikipedia.apk";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","6.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app", apkFile);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void testEmptyAndNotEmptyResults()
    {
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        String search_type_text = "Italy";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                search_type_text,
                "Cannot find element 'Search…'",
                30
        );

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
        waitForElementPresent(
                By.xpath(search_result_locator),
                "Cannot find search result by: " + search_type_text + ".",
                15
        );

        assertElementsPresent(
                By.xpath(search_result_locator),
                "We not found results of " + search_type_text + "."
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find 'close' button",
                5
        );

        String empty_result_label = "//*[@text='Search and read the free encyclopedia in your language']";
        waitForElementPresent(
                By.xpath(empty_result_label),
                "Cannot find empty result labale on page by the request " + search_type_text + ".",
                15
        );

        assertElementNotPresent(
                By.xpath(search_result_locator),
                "We found some result's"
        );
    }

    //Element wait method
    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    //Element wait and click method
    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    // Wait and send keys method
    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    //Assert method size elements <= 1
    private void assertElementsPresent (By by, String error_message)
    {
        List elements = driver.findElements(by);
        int amount_of_elements = elements.size();
        if (amount_of_elements <= 1) {
            String default_message = "An element " + by.toString() + " has no few results";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    //Assert method size elements > 0
    private void assertElementNotPresent(By by, String error_message)
    {
        List elements = driver.findElements(by);
        int amount_of_elements = elements.size();
        if (amount_of_elements > 0) {
            String default_message = "An element " + by.toString() + "not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }
}
