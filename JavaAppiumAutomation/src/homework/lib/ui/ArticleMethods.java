package homework.lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticleMethods extends MainMethods {

    private static final String
            TITLE = "org.wikipedia:id/view_page_title_text",
            TITLE_INPUT = "org.wikipedia:id/text_input",
            THREE_DOTS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
            ADD_TO_READING_LIST_BUTTON = "//*[@text='Add to reading list']",
            OK_BUTTON = "//*[@text='OK']",
            GOT_IT_BUTTON = "org.wikipedia:id/onboarding_button",
            CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
            CREATED_LIST = "//*[@resource-id='org.wikipedia:id/item_container']//*[@text='My reading list']";

    public ArticleMethods(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitElementTitle()
    {
       return this.waitForElementPresent(By.id(TITLE), "Cannot find article title", 15);
    }

    public void clickCloseArticleButton()
    {
        this.waitForElementAndClick(By.xpath(CLOSE_ARTICLE_BUTTON), "Cannot close article, cannot find 'X' button", 10);
    }

    public void createFirstListAndAddArticle()
    {
        this.waitForElementAndClick(
                By.xpath(THREE_DOTS_BUTTON),
                "Cannot find 3-dot button",
                5
        );

        this.waitForElementAndClick(
                By.xpath(ADD_TO_READING_LIST_BUTTON),
                "Cannot find option 'Add to reading list'",
                5
        );

        this.waitForElementAndClick(
                By.id(GOT_IT_BUTTON),
                "Cannot find 'Got it' button",
                5
        );

        this.waitForElementAndClear(
                By.id(TITLE_INPUT),
                "Cannot clear text input on overlay",
                5
        );

        this.waitForElementAndSendKeys(
                By.id(TITLE_INPUT),
                "My reading list",
                "Cannot type text on overlay",
                5
        );

        this.waitForElementAndClick(
                By.xpath(OK_BUTTON),
                "Cannot tap by button 'OK'",
                5
        );
    }

    public void addSecondArticleToList()
    {
        this.waitForElementPresent(
                By.id(TITLE),
                "Cannot find article title",
                15
        );

        this.waitForElementAndClick(
                By.xpath(THREE_DOTS_BUTTON),
                "Cannot find 3-dot button",
                5
        );

        this.waitForElementAndClick(
                By.xpath(ADD_TO_READING_LIST_BUTTON),
                "Cannot find option 'Add to reading list'",
                5
        );

        this.waitForElementAndClick(
                By.xpath(CREATED_LIST),
                "Cannot find reading list 'My reading list'",
                5
        );
    }

    public void findTitleOnPage()
    {
        this.findForElementPresent(By.id(TITLE), "Title not exist on page", 5);
    }
}
