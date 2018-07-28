package homework.lib.ui.ios;

import homework.lib.ui.MyListsMethods;
import io.appium.java_client.AppiumDriver;

public class iOSMyListsMethods extends MyListsMethods {

    static
    {
        CLOSE = "id:Close";
        ARTICLE_BY_TITLE_TPL= "xpath://XCUIElementTypeLink[contains(@name,'{TITLE}')]";
        SECOND_ARTICLE_LIST_NAME = "xpath://XCUIElementTypeApplication[@name='Wikipedia']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell";
        SAVE_FOR_ARTICLE = "id:Save for later";
    }

    public iOSMyListsMethods(AppiumDriver driver)
    {
        super(driver);
    }
}
