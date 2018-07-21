package lessons.lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lessons.lib.Platform;
import lessons.lib.ui.SearchPageObject;
import lessons.lib.ui.android.AndroidSearchPageObject;
import lessons.lib.ui.ios.iOSSearchPageObject;

public class SearchPageObjectFactory
{
    public static SearchPageObject get(AppiumDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidSearchPageObject(driver);
        } else {
            return new iOSSearchPageObject(driver);
        }
    }
}
