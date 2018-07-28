package homework.lib.ui.ios;

import homework.lib.ui.NavigationUIMethods;
import io.appium.java_client.AppiumDriver;

public class iOSNavigationUIMethods extends NavigationUIMethods {

    static
    {
        MY_LISTS_ICON = "id:Saved";
    }

    public iOSNavigationUIMethods(AppiumDriver driver)
    {
        super(driver);
    }


}
