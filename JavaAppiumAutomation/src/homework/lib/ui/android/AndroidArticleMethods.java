package homework.lib.ui.android;

import homework.lib.ui.ArticleMethods;
import io.appium.java_client.AppiumDriver;

public class AndroidArticleMethods extends ArticleMethods {

    static {
                TITLE = "id:org.wikipedia:id/view_page_title_text";
                TITLE_INPUT = "id:org.wikipedia:id/text_input";
                THREE_DOTS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
                ADD_TO_READING_LIST_BUTTON = "xpath://*[@text='Add to reading list']";
                OK_BUTTON = "xpath://*[@text='OK']";
                GOT_IT_BUTTON = "id:org.wikipedia:id/onboarding_button";
                CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
                CREATED_LIST = "xpath://*[@resource-id='org.wikipedia:id/item_container']//*[@text='My reading list']";
    }

    public AndroidArticleMethods(AppiumDriver driver)
    {
        super(driver);
    }
}
