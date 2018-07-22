package homework.tests;

import homework.lib.MainConfig;
import homework.lib.ui.SearchMethods;
import org.junit.Test;

public class Ex3 extends MainConfig {

    @Test
    public void testEmptyAndNotEmptyResults() {
        SearchMethods SearchMethods = new SearchMethods(driver);
        SearchMethods.clickSearchInput();
        String search_line = "Italy";
        SearchMethods.typeSearchInput(search_line);
        SearchMethods.waitForLocatorPresent();
        SearchMethods.checkElementsPresent();
        SearchMethods.clickCloseButton();
        SearchMethods.waitForEmptyLocatorPresent();
        SearchMethods.checkElementNotPresent();
    }
}
