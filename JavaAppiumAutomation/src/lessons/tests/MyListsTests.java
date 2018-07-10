package lessons.tests;

import lessons.lib.CoreTestCase;
import lessons.lib.ui.ArticlePageObject;
import lessons.lib.ui.MyListsPageObject;
import lessons.lib.ui.NavigationUI;
import lessons.lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_folder = "First reading list";
        ArticlePageObject.addArticleToMyList(name_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_folder);
        MyListsPageObject.swipeByArticleToDelete(article_title);
    }

}
