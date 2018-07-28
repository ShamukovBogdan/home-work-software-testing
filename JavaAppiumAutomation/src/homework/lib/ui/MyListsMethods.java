package homework.lib.ui;

import homework.lib.MainPlatform;
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
            TITLE_ELEMENT,
            CLOSE,
            ARTICLE_BY_TITLE_TPL,
            SAVE_FOR_ARTICLE;

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

    public void elementIsEnable()
    {
        this.waitForElementPresent(SAVE_FOR_ARTICLE, "Cannot find save button", 15);
        this.isElementEnabled(SAVE_FOR_ARTICLE);
    }

    public void waitTitlePresent()
    {
        this.waitForElementPresent(TITLE_ELEMENT, "Cannot find article title", 5);
    }

    public void closeiOSPopUpScreen(){
        this.waitForElementAndClick(
                CLOSE,
                "Cannot click skip button on popup screen",
                10
        );
    }

    private static String getArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getArticleXpathByTitle(article_title);
        this.waitForElementPresent(article_xpath, "Cannot find saved article by title " + article_title + "!", 15);
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(article_xpath, "Saved article still present with title" + article_title + "!", 15);
    }

    public void swipeByArticleToDelete(String article_title) {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getArticleXpathByTitle(article_title);
        this.swipeElementToLeft(
                article_xpath,
                "Cannot find  article 'First reading list'"
        );
        if (MainPlatform.getInstance().isIOS()) {
            this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }
}
