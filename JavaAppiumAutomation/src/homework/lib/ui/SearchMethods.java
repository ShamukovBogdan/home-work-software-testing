package homework.lib.ui;

import io.appium.java_client.AppiumDriver;

public class SearchMethods extends MainMethods {

    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_DEFAULT_TEXT,
            SEARCH_RESULT_LOCATOR,
            SEARCH_CLOSE_BUTTON,
            EMPTY_RESULT_LABEL,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT;

    public SearchMethods(AppiumDriver driver)
    {
        super(driver);
    }

    public void initSearchInput()
    {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
    }

    /*TEMPLATES METHODS*/
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES METHODS*/

    public void clickSearchInput()
    {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
    }

    public void clickCloseButton()
    {
        this.waitForElementAndClick(SEARCH_CLOSE_BUTTON, "Cannot click X button and click X button", 5);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 15);
    }

    public void typeSearchInput(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line,"Cannot input" + search_line + "!",5);
    }

    public void checkDefaultLabel()
    {
        this.assertTextNotMatchDefaultLabel(SEARCH_INPUT,SEARCH_DEFAULT_TEXT, "Cannot find search label");
    }

    public void checkElementsPresent()
    {
        this.assertElementsPresent(SEARCH_RESULT_LOCATOR, "We not found results of " + SEARCH_RESULT_LOCATOR );
    }

    public void checkMoreTwoElementsPresent()
    {
        this.assertElementPresentMoreTwoLocators(SEARCH_RESULT_LOCATOR, "We not found results of " + SEARCH_RESULT_LOCATOR );
    }

    public void checkElementNotPresent()
    {
        this.assertElementNotPresent(SEARCH_RESULT_LOCATOR, "We not found some result's");
    }

    public void waitForLocatorPresent()
    {
        this.waitForElementPresent(SEARCH_RESULT_LOCATOR,"Cannot find search result!", 15);
    }

    public void waitForEmptyLocatorPresent()
    {
        this.waitForElementPresent(EMPTY_RESULT_LABEL, "Cannot find empty result label on page by the request", 15);
    }

    public int getAmountOfFoundArticles()
    {
        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request",
                15
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }
}
