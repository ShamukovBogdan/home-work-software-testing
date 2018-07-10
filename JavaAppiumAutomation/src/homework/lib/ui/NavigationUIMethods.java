package homework.lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavigationUIMethods extends MainMethods {

    private static final String
            MY_LISTS_ICON = "//android.widget.FrameLayout[@content-desc='My lists']";

    public NavigationUIMethods(AppiumDriver driver)
    {
        super(driver);
    }

    public void openMyListsSection()
    {
        this.waitForElementAndClick(By.xpath(MY_LISTS_ICON), "Cannot tap on navigation button 'list icon'", 5);
    }
}
