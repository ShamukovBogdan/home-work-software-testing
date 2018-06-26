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

import java.net.URL;

public class Ex2 {

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
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void exerciseTwo()
    {
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        checkElementHasProperText(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find 'Search...' input",
                "Search…",
                "We see unexpected title!"
        );
    }

    /*Methods*/

    // Element waiting method
    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

   // The method of waiting for an element with a parameter of 5 seconds
    private WebElement waitForElementPresent(By by, String error_message)
    {
        return  waitForElementPresent(by, error_message, 5);
    }

    // The method of waiting for an element and clicking on it
    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    // The method of waiting for the element and sending the searched text
    private void checkElementHasProperText(By by, String error_message, String expected_text, String error_message_for_check)
    {
        WebElement element = this.waitForElementPresent(by, error_message);
        checkElementHasText(element, expected_text, error_message_for_check);
    }

    // Text validation method
    private void checkElementHasText (WebElement element, String expected_text, String error_message_fot_check) {
        String current_text = element.getAttribute("text");
        Assert.assertEquals(error_message_fot_check, current_text, expected_text);
    }
}
