package homework.lib.ui.android;

import homework.lib.ui.NavigationUIMethods;
import io.appium.java_client.AppiumDriver;

public class AndroidNavigationUIMethods extends NavigationUIMethods {

    static {
        MY_LISTS_ICON = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
    }

    public AndroidNavigationUIMethods (AppiumDriver driver)
    {
        super(driver);
    }
}
