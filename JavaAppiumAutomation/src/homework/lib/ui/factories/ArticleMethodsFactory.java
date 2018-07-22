package homework.lib.ui.factories;

import homework.lib.MainPlatform;
import homework.lib.ui.ArticleMethods;
import homework.lib.ui.android.AndroidArticleMethods;
import homework.lib.ui.ios.iOSArticleMethods;
import io.appium.java_client.AppiumDriver;

public class ArticleMethodsFactory
{
    public static ArticleMethods get(AppiumDriver driver)
    {
        if(MainPlatform.getInstance().isAndroid()){
            return new AndroidArticleMethods(driver);
        } else {
            return new iOSArticleMethods(driver);
        }
    }
}
