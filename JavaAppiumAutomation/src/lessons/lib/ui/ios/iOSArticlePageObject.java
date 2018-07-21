package lessons.lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lessons.lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser";
        THREE_DOTS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Search";
        WIKIPEDIA_LOGO = "id:Wikipedia, return to Explore";
    }

    public iOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
