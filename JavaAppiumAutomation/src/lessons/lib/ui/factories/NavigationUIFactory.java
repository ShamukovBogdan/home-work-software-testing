package lessons.lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lessons.lib.Platform;
import lessons.lib.ui.NavigationUI;
import lessons.lib.ui.android.AndroidNavigationUI;
import lessons.lib.ui.ios.iOSNavigationUI;

public class NavigationUIFactory {
    public static NavigationUI get(AppiumDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidNavigationUI(driver);
        } else {
            return new iOSNavigationUI(driver);
        }
    }
}
