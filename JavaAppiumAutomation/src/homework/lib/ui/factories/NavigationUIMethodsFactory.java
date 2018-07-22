package homework.lib.ui.factories;

import homework.lib.MainPlatform;
import homework.lib.ui.NavigationUIMethods;
import homework.lib.ui.android.AndroidNavigationUIMethods;
import homework.lib.ui.ios.iOSNavigationUIMethods;
import io.appium.java_client.AppiumDriver;

public class NavigationUIMethodsFactory
{
    public static NavigationUIMethods get(AppiumDriver driver)
    {
        if (MainPlatform.getInstance().isAndroid()){
            return new AndroidNavigationUIMethods(driver);
        } else {
            return new iOSNavigationUIMethods(driver);
        }
    }
}
