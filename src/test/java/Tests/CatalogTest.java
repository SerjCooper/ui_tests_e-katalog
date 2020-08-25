package Tests;

import Pages.CatalogPage;
import Pages.MainPage;
import Pages.SearchResultPage;
import org.testng.annotations.Test;

public class CatalogTest extends BaseTest {

    private MainPage mainPage;
    private SearchResultPage searchResultPage;
    private CatalogPage catalogPage;

    @Test
    public void verifySearchTitleTest(){
        String searchRequest = "Материнские платы";

        browser.getUrl(cfg.url());
        mainPage = new MainPage(browser);
        mainPage
                .search(searchRequest)
                .verifySearchTitle(searchRequest);
    }

    @Test
    public void goToTabTest(){
        String section = "Гаджеты";
        String category = "Мобильные";

        browser.getUrl(cfg.url());
        mainPage = new MainPage(browser);
        mainPage.goToCategory(section, category).verifySearchTitle(category);
    }

}
