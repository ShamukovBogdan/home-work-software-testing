package homework.tests;

import homework.lib.MainConfig;
import homework.lib.ui.ArticleMethods;
import homework.lib.ui.MyListsMethods;
import homework.lib.ui.NavigationUIMethods;
import homework.lib.ui.SearchMethods;
import org.junit.Assert;
import org.junit.Test;

public class Ex5 extends MainConfig {

    @Test
    public void testSaveFewArticleAndRemoveOneOfThem() {
        SearchMethods SearchMethods = new SearchMethods(driver);
        SearchMethods.clickSearchInput();
        SearchMethods.typeSearchInput("Brest");
        SearchMethods.clickByArticleWithSubstring("City in Belarus");

        ArticleMethods ArticleMethods = new ArticleMethods(driver);
        ArticleMethods.waitElementTitle();
        ArticleMethods.createFirstListAndAddArticle();
        ArticleMethods.clickCloseArticleButton();
        //Search second article
        SearchMethods.clickSearchInput();
        SearchMethods.typeSearchInput("Brest");
        SearchMethods.clickByArticleWithSubstring("Commune in Finistère, France");
        //Add second article
        ArticleMethods.addSecondArticleToList();
        ArticleMethods.clickCloseArticleButton();

        NavigationUIMethods NavigationUIMethods = new NavigationUIMethods(driver);
        NavigationUIMethods.openMyListsSection();

        MyListsMethods MyListsMethods = new MyListsMethods(driver);
        MyListsMethods.waitAllLocatorsOnList();
        MyListsMethods.clickByList();
        MyListsMethods.deleteListViaSwipe();
        MyListsMethods.waitListNotPresent();
        MyListsMethods.waitListPresent();
        MyListsMethods.clickByArticle();
        MyListsMethods.waitTitlePresent();
        String article_title = MyListsMethods.getArticleTitle();
        Assert.assertEquals(
                "We see unexpected title!",
                "Subprefecture and commune in Brittany, France",
                article_title
        );
    }
}
