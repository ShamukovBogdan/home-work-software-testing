package homework.lib.ui;

import homework.lib.MainPlatform;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticleMethods extends MainMethods {

    protected static String
            TITLE,
            FIRST_IOS_TITLE,
            SECOND_IOS_TITLE,
            TITLE_INPUT,
            THREE_DOTS_BUTTON,
            THREE_DOTS_ADD_TO_MY_LIST_BUTTON,
            ADD_TO_READING_LIST_BUTTON,
            OK_BUTTON,
            GOT_IT_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            CREATED_LIST,
            WIKIPEDIA_LOGO;

    public ArticleMethods(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitElementTitle()
    {
       return this.waitForElementPresent(TITLE, "Cannot find article title", 25);
    }

    public WebElement waitIOSElementTitle()
    {
        return this.waitForElementPresent(FIRST_IOS_TITLE, "Cannot find First TITLE", 25);
    }

    public WebElement waitIOSSecondElementTitle()
    {
        return this.waitForElementPresent(SECOND_IOS_TITLE, "Cannot find Second TITLE", 25);
    }

    public String getTitleForSecondArticle()
    {
        if (MainPlatform.getInstance().isAndroid()){
            WebElement title_element = waitElementTitle();
            return title_element.getAttribute("text");
        } else {
            WebElement title_element = waitIOSSecondElementTitle();
            return title_element.getAttribute("name");
        }
    }

    public String getArticleTitle()
    {
        if (MainPlatform.getInstance().isAndroid()){
            WebElement title_element = waitElementTitle();
            return title_element.getAttribute("text");
        } else {
            WebElement title_element = waitIOSElementTitle();
            return title_element.getAttribute("name");
        }
    }

    public void clickCloseArticleButton()
    {
        {
            if (MainPlatform.getInstance().isAndroid()) {
                this.waitForElementAndClick(
                        CLOSE_ARTICLE_BUTTON,
                        "Cannot close article, cannot find 'X' button",
                        10
                );
            } else {
                this.waitForElementAndClick(
                        WIKIPEDIA_LOGO,
                        "Cannot click by 'Wikipedia, return to Explore'",
                        10
                );
            }
        }
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

    public void addArticlesToMySaved(){
        this.waitForElementAndClick(
                THREE_DOTS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find add article button!",
                10
        );
    }

    public void findTitleIsPresentOnPage()
    {
        this.findForElementPresent(TITLE, "Title not exist on page", 5);
    }
}
