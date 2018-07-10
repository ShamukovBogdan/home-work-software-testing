package homework.tests;

import homework.lib.MainConfig;
import homework.lib.ui.ArticleMethods;
import homework.lib.ui.SearchMethods;
import org.junit.Test;

public class Ex6 extends MainConfig {

    @Test
    public void testElementIsExist() {

        SearchMethods SearchMethods = new SearchMethods(driver);
        SearchMethods.clickSearchInput();
        SearchMethods.typeSearchInput("Brest");
        SearchMethods.clickByArticleWithSubstring("City in Belarus");

        ArticleMethods ArticleMethods = new ArticleMethods(driver);
        ArticleMethods.findTitleOnPage();
    }
}
