package homework.lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class MyListsMethods extends MainMethods {

    protected static String
            LOCATOR_FOR_OPTION_1,
            LOCATOR_FOR_OPTION_2,
            LOCATOR_FOR_OPTION_3,
            LOCATOR_FOR_OPTION_4,
            LOCATOR_FOR_OPTION_5,
            LOCATOR_FOR_OPTION_6,
            LIST_NAME,
            FIRST_ARTICLE_LIST_NAME,
            SECOND_ARTICLE_LIST_NAME,
            TITLE_ELEMENT;

    public MyListsMethods(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE_ELEMENT, "Cannot find article title on page!", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void waitAllLocatorsOnList()
    {
        waitForMenuInit(
                LOCATOR_FOR_OPTION_1,
                LOCATOR_FOR_OPTION_2,
                LOCATOR_FOR_OPTION_3,
                LOCATOR_FOR_OPTION_4,
                LOCATOR_FOR_OPTION_5,
                LOCATOR_FOR_OPTION_6
        );
    }

    public void clickByList()
    {
        this.waitForElementAndClick(LIST_NAME, "Cannot find 'My reading list' folder",5);
    }

    public void deleteListViaSwipe()
    {
        this.swipeElementToLeft(FIRST_ARTICLE_LIST_NAME, "Cannot find article 'city in Belarus");
    }

    public void waitListNotPresent()
    {
        this.waitForElementNotPresent(FIRST_ARTICLE_LIST_NAME, "Deleted article still present", 5);
    }

    public void waitListPresent()
    {
        this.waitForElementPresent(SECOND_ARTICLE_LIST_NAME, "Cannot find saved article!", 5);
    }

    public void clickByArticle()
    {
        this.waitForElementAndClick(SECOND_ARTICLE_LIST_NAME, "Cannot click by saved article!", 5);
    }

    public void waitTitlePresent()
    {
        this.waitForElementPresent(TITLE_ELEMENT, "Cannot find article title", 5);
    }


}
