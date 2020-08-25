package Tests;

import Pages.MainPage;
import Pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends BaseTest {

    private MainPage mainPage;
    private SearchResultPage searchResultPage;

    @Test
    public void verifySearchTitleTest(){
        String searchRequest = "Материнские платы";

        browser.getUrl(cfg.url());
        mainPage = new MainPage(browser);
        searchResultPage = mainPage.search(searchRequest);
        Assert.assertTrue(searchResultPage.getSearchTitle().contains(searchRequest), "Текст исходного запроса " +
                "не совпадает с заголовком страницы с результатами поиска");
    }
}
