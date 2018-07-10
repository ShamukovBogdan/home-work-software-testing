package homework.lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyListMethods extends MainMethods {

    private static final String
            LOCATOR_FOR_OPTION_1 = "//*[@resource-id='org.wikipedia:id/item_image_1']",
            LOCATOR_FOR_OPTION_2 = "//*[@resource-id='org.wikipedia:id/item_image_2']",
            LOCATOR_FOR_OPTION_3 = "//*[@resource-id='org.wikipedia:id/item_image_3']",
            LOCATOR_FOR_OPTION_4 = "//*[@resource-id='org.wikipedia:id/item_image_4']",
            LOCATOR_FOR_OPTION_5 = "//*[@resource-id='org.wikipedia:id/item_container']//*[@text='My reading list']",
            LOCATOR_FOR_OPTION_6 = "//*[@resource-id='org.wikipedia:id/item_overflow_menu']",
            LIST_NAME = "//android.widget.TextView[@text='My reading list']",
            FIRST_ARTICLE_LIST_NAME = "//*[@text='city in Belarus']",
            SECOND_ARTICLE_LIST_NAME = "//*[@text='commune in Finistère, France']",
            TITLE_ELEMENT = "org.wikipedia:id/view_page_subtitle_text";

    public MyListMethods(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.id(TITLE_ELEMENT), "Cannot find article title on page!", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void waitAllLocatorsOnList()
    {
        waitForMenuInit(
                By.xpath(LOCATOR_FOR_OPTION_1),
                By.xpath(LOCATOR_FOR_OPTION_2),
                By.xpath(LOCATOR_FOR_OPTION_3),
                By.xpath(LOCATOR_FOR_OPTION_4),
                By.xpath(LOCATOR_FOR_OPTION_5),
                By.xpath(LOCATOR_FOR_OPTION_6)
        );
    }

    public void clickByList()
    {
        this.waitForElementAndClick(By.xpath(LIST_NAME), "Cannot find 'My reading list' folder",5);
    }

    public void deleteListViaSwipe()
    {
        this.swipeElementToLeft(By.xpath(FIRST_ARTICLE_LIST_NAME), "Cannot find article 'city in Belarus");
    }

    public void waitListNotPresent()
    {
        this.waitForElementNotPresent(By.xpath(FIRST_ARTICLE_LIST_NAME), "Deleted article still present", 5);
    }

    public void waitListPresent()
    {
        this.waitForElementPresent(By.xpath(SECOND_ARTICLE_LIST_NAME), "Cannot find saved article!", 5);
    }

    public void clickByArticle()
    {
        this.waitForElementAndClick(By.xpath(SECOND_ARTICLE_LIST_NAME), "Cannot click by saved article!", 5);
    }

    public void waitTitlePresent()
    {
        this.waitForElementPresent(By.id(TITLE_ELEMENT), "Cannot find article title", 5);
    }
}
