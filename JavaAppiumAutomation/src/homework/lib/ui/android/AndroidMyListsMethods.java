package homework.lib.ui.android;

import homework.lib.ui.MyListsMethods;
import io.appium.java_client.AppiumDriver;

public class AndroidMyListsMethods extends MyListsMethods {

    static {
                LOCATOR_FOR_OPTION_1 = "xpath://*[@resource-id='org.wikipedia:id/item_image_1']";
                LOCATOR_FOR_OPTION_2 = "xpath://*[@resource-id='org.wikipedia:id/item_image_2']";
                LOCATOR_FOR_OPTION_3 = "xpath://*[@resource-id='org.wikipedia:id/item_image_3']";
                LOCATOR_FOR_OPTION_4 = "xpath://*[@resource-id='org.wikipedia:id/item_image_4']";
                LOCATOR_FOR_OPTION_5 = "xpath://*[@resource-id='org.wikipedia:id/item_container']//*[@text='My reading list']";
                LOCATOR_FOR_OPTION_6 = "xpath://*[@resource-id='org.wikipedia:id/item_overflow_menu']";
                LIST_NAME = "xpath://android.widget.TextView[@text='My reading list']";
                FIRST_ARTICLE_LIST_NAME = "xpath://*[@text='city in Belarus']";
                SECOND_ARTICLE_LIST_NAME = "xpath://*[@text='commune in Finistère, France']";
                TITLE_ELEMENT = "id:org.wikipedia:id/view_page_subtitle_text";
    }

    public AndroidMyListsMethods (AppiumDriver driver)
    {
        super(driver);
    }
}
