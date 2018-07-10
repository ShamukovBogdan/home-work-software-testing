package homework.lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchMethods extends MainMethods {

    private static final String
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text, 'Search…')]",
            SEARCH_DEFAULT_TEXT = "Search…",
            SEARCH_RESULT_LOCATOR = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']",
            SEARCH_CLOSE_BUTTON = "org.wikipedia:id/search_close_btn",
            EMPTY_RESULT_LABEL = "//*[@text='Search and read the free encyclopedia in your language']",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";

    public SearchMethods(AppiumDriver driver)
    {
        super(driver);
    }

    /*TEMPLATES METHODS*/
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES METHODS*/

    public void clickSearchInput()
    {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element");
    }

    public void clickCloseButton()
    {
        this.waitForElementAndClick(By.id(SEARCH_CLOSE_BUTTON), "Cannot click X button and click X button", 5);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result with substring " + substring, 15);
    }

    public void typeSearchInput(String search_line)
    {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line,"Cannot input" + search_line + "!",5);
    }

    public void checkDefaultLabel()
    {
        this.assertTextNotMatchDefaultLabel(By.xpath(SEARCH_INPUT),SEARCH_DEFAULT_TEXT, "Cannot find search label");
    }

    public void checkElementsPresent()
    {
        this.assertElementsPresent(By.xpath(SEARCH_RESULT_LOCATOR), "We not found results of " + SEARCH_RESULT_LOCATOR );
    }

    public void checkElementNotPresent()
    {
        this.assertElementNotPresent(By.xpath(SEARCH_RESULT_LOCATOR), "We found some result's");
    }

    public void waitForLocatorPresent()
    {
        this.waitForElementPresent(By.xpath(SEARCH_RESULT_LOCATOR),"Cannot find search result!", 15);
    }

    public void waitForEmptyLocatorPresent()
    {
        this.waitForElementPresent(By.xpath(EMPTY_RESULT_LABEL), "Cannot find empty result label on page by the request", 15);
    }
}
