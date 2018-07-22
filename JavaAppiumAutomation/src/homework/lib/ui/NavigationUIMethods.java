package homework.lib.ui;

import io.appium.java_client.AppiumDriver;

public class NavigationUIMethods extends MainMethods {

    protected static String
            MY_LISTS_ICON;

    public NavigationUIMethods(AppiumDriver driver)
    {
        super(driver);
    }

    public void openMyListsSection()
    {
        this.waitForElementAndClick(MY_LISTS_ICON, "Cannot tap on navigation button 'list icon'", 5);
    }
}
