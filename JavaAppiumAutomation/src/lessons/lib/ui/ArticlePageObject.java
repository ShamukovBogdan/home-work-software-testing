package lessons.lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject{

    private static final String
            TITLE = "org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT= "//*[@text='View page in browser']",
            THREE_DOTS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
            THREE_DOTS_ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to reading list']",
            OVERLAY_GOT_IT_BUTTON = "org.wikipedia:id/onboarding_button",
            MY_LIST_INPUT = "org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "//*[@text='OK']",
            CLOSE_ARTICLE_BUTTON ="//android.widget.ImageButton[@content-desc='Navigate up']";


    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article title on page!", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot find footer article!",
                20
        );
    }

    public void addArticleToMyList(String name_folder)
    {
        this.waitForElementAndClick(
                By.xpath(THREE_DOTS_BUTTON),
                "Cannot find 3-dot button",
                5
        );

        this.waitForElementAndClick(
                By.xpath(THREE_DOTS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find option 'Add to reading list'",
                5
        );

        this.waitForElementAndClick(
                By.id(OVERLAY_GOT_IT_BUTTON),
                "Cannot fing 'Got it' button",
                5
        );

        this.waitForElementAndClear(
                By.id(MY_LIST_INPUT),
                "Cannot clear text input on overlay",
                5
        );

        this.waitForElementAndSendKeys(
                By.id(MY_LIST_INPUT),
                name_folder,
                "Cannot type text on overlay",
                5
        );

        this.waitForElementAndClick(
                By.xpath(MY_LIST_OK_BUTTON),
                "Cannot tap by button 'OK'",
                5
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Cannot close article, cannot find 'X' button",
                5
        );
    }
}
