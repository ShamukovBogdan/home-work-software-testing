package homework.tests;

import homework.lib.MainConfig;
import homework.lib.MainPlatform;
import homework.lib.ui.*;
import homework.lib.ui.factories.ArticleMethodsFactory;
import homework.lib.ui.factories.MyListsMethodsFactory;
import homework.lib.ui.factories.NavigationUIMethodsFactory;
import homework.lib.ui.factories.SearchMethodsFactory;
import org.junit.Assert;
import org.junit.Test;

public class Ex10 extends MainConfig {

    @Test
    public void testIOSSaveFewArticleAndRemoveOneOfThem() {
        SearchMethods SearchMethods = SearchMethodsFactory.get(driver);

        SearchMethods.initSearchInput();
        SearchMethods.typeSearchInput("Brest");
        if (MainPlatform.getInstance().isAndroid()) {
            SearchMethods.clickByArticleWithSubstring("City in Belarus");
        } else {
            SearchMethods.clickByArticleWithSubstring("Place in Brest Region, Belarus");
        }

        ArticleMethods ArticleMethods = ArticleMethodsFactory.get(driver);
        if (MainPlatform.getInstance().isIOS()) {
            ArticleMethods.waitIOSElementTitle();
            ArticleMethods.addArticlesToMySaved();
        } else {
            ArticleMethods.waitElementTitle();
            ArticleMethods.createFirstListAndAddArticle();
        }
        ArticleMethods.clickCloseArticleButton();


        SearchMethods.initSearchInput();
        SearchMethods.typeSearchInput("Brest");
        if (MainPlatform.getInstance().isAndroid()) {
            SearchMethods.clickByArticleWithSubstring("Commune in Finistère, France");
        } else {
            SearchMethods.clickByArticleWithSubstring("Subprefecture and commune in Brittany, France");
        }

        ArticleMethods SecondArticleMethods = ArticleMethodsFactory.get(driver);
        if (MainPlatform.getInstance().isIOS()) {
            SecondArticleMethods.waitIOSSecondElementTitle();
            ArticleMethods.addArticlesToMySaved();
        } else {
            ArticleMethods.waitElementTitle();
            ArticleMethods.addSecondArticleToList();
        }
        ArticleMethods.clickCloseArticleButton();

        NavigationUIMethods NavigationUIMethods = NavigationUIMethodsFactory.get(driver);
        NavigationUIMethods.openMyListsSection();

        MyListsMethods MyListMethods = MyListsMethodsFactory.get(driver);
        if (MainPlatform.getInstance().isAndroid()) {
            MyListMethods.waitAllLocatorsOnList();
            MyListMethods.clickByList();
            MyListMethods.deleteListViaSwipe();
            MyListMethods.waitListNotPresent();
            MyListMethods.clickByArticle();
            MyListMethods.waitTitlePresent();
            String article_title = MyListMethods.getArticleTitle();
            Assert.assertEquals(
                    "We see unexpected title!",
                    "Subprefecture and commune in Brittany, France",
                    article_title
            );
        } else {
            MyListMethods.closeiOSPopUpScreen();
            MyListMethods.swipeByArticleToDelete("Brest, Belarus");
            //MyListMethods.clickByArticle();
            int amount_of_search_results = SearchMethods.getAmountOfFoundArticles();
            assertTrue(
                    "We found too few results of Brest",
                    amount_of_search_results == 1
            );

        }
    }
}
