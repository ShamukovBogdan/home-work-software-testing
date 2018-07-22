package homework.lib.ui.android;

import homework.lib.ui.SearchMethods;
import io.appium.java_client.AppiumDriver;

public class AndroidSearchMethods extends SearchMethods {

    static {
                SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
                SEARCH_INPUT = "xpath://*[contains(@text, 'Search…')]";
                SEARCH_DEFAULT_TEXT = "Search…";
                SEARCH_RESULT_LOCATOR = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
                SEARCH_CLOSE_BUTTON = "id:org.wikipedia:id/search_close_btn";
                EMPTY_RESULT_LABEL = "xpath://*[@text='Search and read the free encyclopedia in your language']";
                SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";
    }

    public AndroidSearchMethods (AppiumDriver driver)
    {
        super(driver);
    }
}
