package lessons.tests;

import lessons.lib.CoreTestCase;
import lessons.lib.Platform;
import lessons.lib.ui.ArticlePageObject;
import lessons.lib.ui.MyListsPageObject;
import lessons.lib.ui.NavigationUI;
import lessons.lib.ui.SearchPageObject;
import lessons.lib.ui.factories.ArticlePageObjectFactory;
import lessons.lib.ui.factories.MyListsPageObjectFactory;
import lessons.lib.ui.factories.NavigationUIFactory;
import lessons.lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    private final static String
            name_folder = "First reading list";

    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.openFolderByName(name_folder);
        } else {

        }

        MyListsPageObject.swipeByArticleToDelete(article_title);
    }

}
