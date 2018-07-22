package homework.lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import homework.lib.ui.WelcomeMethods;
import org.openqa.selenium.ScreenOrientation;


public class MainConfig extends TestCase {

    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        driver = MainPlatform.getInstance().getDriver();
        this.rotateScreenPortrait();
        this.skipWelcomePageForIOSApp();
    }

    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();
        super.tearDown();
    }

    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp(int seconds)
    {
        driver.runAppInBackground(seconds);
    }

    private void skipWelcomePageForIOSApp()
    {
        if (MainPlatform.getInstance().isIOS()){
            WelcomeMethods WelcomePageObject = new WelcomeMethods(driver);
            WelcomePageObject.clickSkip();
        }
    }
}