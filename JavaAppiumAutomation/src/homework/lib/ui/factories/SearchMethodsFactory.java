package homework.lib.ui.factories;

import homework.lib.MainPlatform;
import homework.lib.ui.SearchMethods;
import homework.lib.ui.android.AndroidSearchMethods;
import homework.lib.ui.ios.iOSSearchMethods;
import io.appium.java_client.AppiumDriver;

public class SearchMethodsFactory
{
    public static SearchMethods get(AppiumDriver driver)
    {
        if (MainPlatform.getInstance().isAndroid()) {
            return new AndroidSearchMethods(driver);
        } else {
            return new iOSSearchMethods(driver);
        }
    }
}
