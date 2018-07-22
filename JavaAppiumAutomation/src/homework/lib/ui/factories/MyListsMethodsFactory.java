package homework.lib.ui.factories;

import homework.lib.MainPlatform;
import homework.lib.ui.MyListsMethods;
import homework.lib.ui.android.AndroidMyListsMethods;
import homework.lib.ui.ios.iOSMyListsMethods;
import io.appium.java_client.AppiumDriver;

public class MyListsMethodsFactory
{
    public static MyListsMethods get(AppiumDriver driver)
    {
        if(MainPlatform.getInstance().isAndroid()){
            return new AndroidMyListsMethods(driver);
        } else {
            return new iOSMyListsMethods(driver);
        }
    }
}
