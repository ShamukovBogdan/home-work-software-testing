package lessons.lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lessons.lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {

    static {
                TITLE = "id:org.wikipedia:id/view_page_title_text";
                FOOTER_ELEMENT = "xpath://*[@text='View page in browser']";
                THREE_DOTS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
                THREE_DOTS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to reading list']";
                OVERLAY_GOT_IT_BUTTON = "id:org.wikipedia:id/onboarding_button";
                MY_LIST_INPUT = "id:org.wikipedia:id/text_input";
                MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
                CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
    }

    public AndroidArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
