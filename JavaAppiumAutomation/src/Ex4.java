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

public class Ex4 {

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
    public void exerciseFour() {

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Mercedes-Benz",
                "Cannot find 'Search...' input",
                15
        );

        waitForElementPresent(
                By.id("//*[@resource-id='org.wikipedia:id/page_list_item_title']//*[contains(@text='Mercedes-Benz']"),
                "Cannot find text 'Mercedes-Benz",
                15
        );

        /*waitForElementAndFindAllElements(
                By.id("org.wikipedia:id/page_list_item_title"),
                "Cannot find 'Mercedes-Benz' text on search result",
                30
        );*/
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

    // Wait and click method
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

    private WebElement waitForElementAndFindAllElements(By by, String error_message, long timeoutInSeconds) {
        WebElement search_element = waitForElementPresent(by, error_message, timeoutInSeconds);
        search_element.findElements(By.linkText("//*[contains(@text='Mercedes-Benz']"));
        return search_element;
    }
}

