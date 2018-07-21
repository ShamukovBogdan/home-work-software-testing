package lessons.lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lessons.lib.Platform;
import lessons.lib.ui.MyListsPageObject;
import lessons.lib.ui.android.AndroidMyListsPageObject;
import lessons.lib.ui.ios.iOSMyListsPageObject;

public class MyListsPageObjectFactory
{
    public static MyListsPageObject get(AppiumDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidMyListsPageObject(driver);
        } else {
            return new iOSMyListsPageObject(driver);
        }
    }
}
