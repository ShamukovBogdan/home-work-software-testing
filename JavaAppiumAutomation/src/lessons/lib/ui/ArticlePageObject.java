package lessons.lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import lessons.lib.Platform;

abstract public class ArticlePageObject extends MainPageObject{

    protected static String
            TITLE,
            FOOTER_ELEMENT,
            THREE_DOTS_BUTTON,
            THREE_DOTS_ADD_TO_MY_LIST_BUTTON,
            OVERLAY_GOT_IT_BUTTON,
            MY_LIST_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            WIKIPEDIA_LOGO;


    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page!", 25);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }

    }

    public void swipeToFooter()
    {
        if (Platform.getInstance().isAndroid()){
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find footer article!",
                    40
            );
        } else {
            this.swipeUpTillElementAppear(
                    FOOTER_ELEMENT,
                    "Cannot find footer article!",
                    40
            );
        }

    }

    public void addArticleToMyList(String name_folder)
    {
        this.waitForElementAndClick(
                THREE_DOTS_BUTTON,
                "Cannot find 3-dot button",
                5
        );

        this.waitForElementAndClick(
                THREE_DOTS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option 'Add to reading list'",
                5
        );

        this.waitForElementAndClick(
                OVERLAY_GOT_IT_BUTTON,
                "Cannot fing 'Got it' button",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_INPUT,
                "Cannot clear text input on overlay",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_INPUT,
                name_folder,
                "Cannot type text on overlay",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot tap by button 'OK'",
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

    public void closeArticle()
    {
        if (Platform.getInstance().isAndroid()) {
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
