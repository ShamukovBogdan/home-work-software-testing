package lessons.lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lessons.lib.Platform;
import lessons.lib.ui.ArticlePageObject;
import lessons.lib.ui.android.AndroidArticlePageObject;
import lessons.lib.ui.ios.iOSArticlePageObject;

public class ArticlePageObjectFactory
{
    public static ArticlePageObject get(AppiumDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidArticlePageObject(driver);
        } else {
            return new iOSArticlePageObject(driver);
        }
    }
}
