package homework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
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

public class Ex5 {

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
    public void testSaveFewArticleAndRemoveOneOfThem()
    {
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        //Search first article
        String search_text = "Brest";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                search_text,
                "Cannot find element 'Search…'",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='City in Belarus']"),
                "Cannot find 'City in Belarus' topic search in " + search_text,
                15
        );

        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find 3-dot button",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find option 'Add to reading list'",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find 'Got it' button",
                5
        );

        waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "Cannot clear text input on overlay",
                5
        );

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                "My reading list",
                "Cannot type text on overlay",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot tap by button 'OK'",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find 'X' button",
                5
        );

        //Search second article
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/recent_searches_list']//*[@text='Brest']"),
                "Cannot find element 'Brest' in recent search",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Commune in Finistère, France']"),
                "Cannot find 'Commune in Finistère, France' topic search in " + search_text,
                5
        );

        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find 3-dot button",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find option 'Add to reading list'",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/item_container']//*[@text='My reading list']"),
                "Cannot find reading list 'My reading list'",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find 'X' button",
                10
        );

        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot tap on navigation button 'list icon'",
                5
        );

        String LOCATOR_FOR_OPTION_1 = "//*[@resource-id='org.wikipedia:id/item_image_1']";
        String LOCATOR_FOR_OPTION_2 = "//*[@resource-id='org.wikipedia:id/item_image_2']";
        String LOCATOR_FOR_OPTION_3 = "//*[@resource-id='org.wikipedia:id/item_image_3']";
        String LOCATOR_FOR_OPTION_4 = "//*[@resource-id='org.wikipedia:id/item_image_4']";
        String LOCATOR_FOR_OPTION_5 = "//*[@resource-id='org.wikipedia:id/item_container']//*[@text='My reading list']";
        String LOCATOR_FOR_OPTION_6 = "//*[@resource-id='org.wikipedia:id/item_overflow_menu']";
        waitForMenuInit(
                By.xpath(LOCATOR_FOR_OPTION_1),
                By.xpath(LOCATOR_FOR_OPTION_2),
                By.xpath(LOCATOR_FOR_OPTION_3),
                By.xpath(LOCATOR_FOR_OPTION_4),
                By.xpath(LOCATOR_FOR_OPTION_5),
                By.xpath(LOCATOR_FOR_OPTION_6)
        );

        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='My reading list']"),
                "Cannot find 'My reading list' folder",
                5
        );

        //Delete first element
        swipeElementToLeft(
                By.xpath("//*[@text='city in Belarus']"),
                "Cannot find article 'city in Belarus'"
        );

        waitForElementNotPresent(
                By.xpath("//*[@text='city in Belarus']"),
                "Cannot delete saved article",
                5
        );

        waitForElementPresent(
                By.xpath("//*[@text='commune in Finistère, France']"),
                "Cannot find saved article",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='commune in Finistère, France']"),
                "Cannot click by 'commune in Finistère, France'",
                15
        );

        WebElement title_element = waitForElementPresent(
                By.id("org.wikipedia:id/view_page_subtitle_text"),
                "Cannot find article title",
                15
        );

        String article_title = title_element.getAttribute("text");

        Assert.assertEquals(
                "We see unexpected title!",
                "Subprefecture and commune in Brittany, France",
                article_title
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

    // Wait not present element method
    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
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

    // Wait and clear element method
    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    //Swipe left method
    protected void swipeElementToLeft(By by, String error_message)
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

    private void waitForMenuInit(By LOCATOR_FOR_OPTION_1, By LOCATOR_FOR_OPTION_2, By LOCATOR_FOR_OPTION_3, By LOCATOR_FOR_OPTION_4, By LOCATOR_FOR_OPTION_5, By LOCATOR_FOR_OPTION_6)
    {
        waitForElementPresent(LOCATOR_FOR_OPTION_1, "Can't wait first locator", 10);
        waitForElementPresent(LOCATOR_FOR_OPTION_2,"Can't wait second locator", 10);
        waitForElementPresent(LOCATOR_FOR_OPTION_3,"Can't wait third locator", 10);
        waitForElementPresent(LOCATOR_FOR_OPTION_4,"Can't wait fourth locator", 10);
        waitForElementPresent(LOCATOR_FOR_OPTION_5,"Can't wait fifth locator", 10);
        waitForElementPresent(LOCATOR_FOR_OPTION_6,"Can't wait sixth locator", 10);
    }
}
