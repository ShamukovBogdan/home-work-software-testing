package homework.tests;

import homework.lib.MainConfig;
import homework.lib.ui.SearchMethods;
import homework.lib.ui.factories.SearchMethodsFactory;
import org.junit.Test;

public class Ex11 extends MainConfig {

    @Test
    public void testCheckSearchForThreeResults()
    {
        SearchMethods SearchMethods = SearchMethodsFactory.get(driver);
        SearchMethods.initSearchInput();
        String search_line = "Italy";
        SearchMethods.typeSearchInput(search_line);
        int amount_of_search_results = SearchMethods.getAmountOfFoundArticles();
        assertTrue(
                "We found too few results of" + search_line,
                amount_of_search_results > 2
        );
        SearchMethods.clickCloseButton();
    }
}
