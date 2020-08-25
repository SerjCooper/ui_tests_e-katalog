package Pages;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BasePage {

    private final By searchTitleXpath = By.xpath("//div[contains(@class, 'page-title')]/h1");

    public SearchResultPage(Browser browser) {
        super(browser);
    }

    public String getSearchTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchTitleXpath));
        return driver.findElement(searchTitleXpath).getText();
    }
}
