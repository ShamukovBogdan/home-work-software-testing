package homework.tests;

import homework.lib.MainConfig;
import homework.lib.ui.SearchMethods;
import org.junit.Test;

public class Ex2 extends MainConfig {

    @Test
    public void testCheckTextElementInSearchInput()
    {
        SearchMethods SearchMethods = new SearchMethods(driver);
        SearchMethods.clickSearchInput();
        SearchMethods.checkDefaultLabel();
    }
}
