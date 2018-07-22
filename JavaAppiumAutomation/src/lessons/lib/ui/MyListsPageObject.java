package lessons.lib.ui;

import io.appium.java_client.AppiumDriver;
import lessons.lib.Platform;

abstract public class MyListsPageObject extends MainPageObject {

    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TPL,
            CLOSE;

    private static String getFolderXpathByName(String name_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_folder);
    }

    private static String getArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name " + name_folder,
                5
        );
    }

    public void closeiOSPopUpScreen(){
        this.waitForElementAndClick(
                CLOSE,
                "Cannot click skip button on popup screen",
                10
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getArticleXpathByTitle(article_title);
        this.waitForElementPresent(article_xpath, "Cannot find saved article by title " + article_title + "!", 15);
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(article_xpath, "Saved article still present with title" + article_title + "!", 15);
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getArticleXpathByTitle(article_title);
        this.swipeElementToLeft(
                article_xpath,
                "Cannot find  article 'First reading list'"
        ); if (Platform.getInstance().isIOS()){
            this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }
}
