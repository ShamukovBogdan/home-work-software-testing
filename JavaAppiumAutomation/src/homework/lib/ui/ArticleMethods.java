package homework.lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticleMethods extends MainMethods {

    protected static String
            TITLE,
            TITLE_INPUT,
            THREE_DOTS_BUTTON,
            ADD_TO_READING_LIST_BUTTON,
            OK_BUTTON,
            GOT_IT_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            CREATED_LIST;

    public ArticleMethods(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitElementTitle()
    {
       return this.waitForElementPresent(TITLE, "Cannot find article title", 15);
    }

    public void clickCloseArticleButton()
    {
        this.waitForElementAndClick(CLOSE_ARTICLE_BUTTON, "Cannot close article, cannot find 'X' button", 10);
    }

    public void createFirstListAndAddArticle()
    {
        this.waitForElementAndClick(
                THREE_DOTS_BUTTON,
                "Cannot find 3-dot button",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_READING_LIST_BUTTON,
                "Cannot find option 'Add to reading list'",
                5
        );

        this.waitForElementAndClick(
                GOT_IT_BUTTON,
                "Cannot find 'Got it' button",
                5
        );

        this.waitForElementAndClear(
                TITLE_INPUT,
                "Cannot clear text input on overlay",
                5
        );

        this.waitForElementAndSendKeys(
                TITLE_INPUT,
                "My reading list",
                "Cannot type text on overlay",
                5
        );

        this.waitForElementAndClick(
                OK_BUTTON,
                "Cannot tap by button 'OK'",
                5
        );
    }

    public void addSecondArticleToList()
    {
        this.waitForElementPresent(
                TITLE,
                "Cannot find article title",
                15
        );

        this.waitForElementAndClick(
                THREE_DOTS_BUTTON,
                "Cannot find 3-dot button",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_READING_LIST_BUTTON,
                "Cannot find option 'Add to reading list'",
                5
        );

        this.waitForElementAndClick(
                CREATED_LIST,
                "Cannot find reading list 'My reading list'",
                5
        );
    }

    public void findTitleIsPresentOnPage()
    {
        this.findForElementPresent(TITLE, "Title not exist on page", 5);
    }
}
