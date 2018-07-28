package homework.lib.ui.ios;

import homework.lib.ui.ArticleMethods;
import io.appium.java_client.AppiumDriver;

public class iOSArticleMethods extends ArticleMethods {

    static
    {
        TITLE = "id:Java (programming language)";
        FIRST_IOS_TITLE = "id:Brest, Belarus";
        SECOND_IOS_TITLE = "id:Subprefecture and commune in Brittany, France";
        THREE_DOTS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Search";
        WIKIPEDIA_LOGO = "id:Wikipedia, return to Explore";
    }

    public iOSArticleMethods(AppiumDriver driver)
    {
        super(driver);
    }
}
