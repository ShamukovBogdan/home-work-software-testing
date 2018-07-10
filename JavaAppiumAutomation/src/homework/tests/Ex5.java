package homework.tests;

import homework.lib.MainConfig;
import homework.lib.ui.ArticleMethods;
import homework.lib.ui.MyListMethods;
import homework.lib.ui.NavigationUIMethods;
import homework.lib.ui.SearchMethods;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        MyListMethods MyListMethods = new MyListMethods(driver);
        MyListMethods.waitAllLocatorsOnList();
        MyListMethods.clickByList();
        MyListMethods.deleteListViaSwipe();
        MyListMethods.waitListNotPresent();
        MyListMethods.waitListPresent();
        MyListMethods.clickByArticle();
        MyListMethods.waitTitlePresent();
        String article_title = MyListMethods.getArticleTitle();
        Assert.assertEquals(
                "We see unexpected title!",
                "Subprefecture and commune in Brittany, France",
                article_title
        );
    }
}
