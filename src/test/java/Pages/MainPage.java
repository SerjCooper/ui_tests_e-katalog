package Pages;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    private final By searchBarXpath = By.xpath("//input[contains(@id,'ek-search')]");

    public MainPage(Browser browser) {
        super(browser);
    }

    public SearchResultPage search(String request) {
        wait.until(ExpectedConditions.elementToBeClickable(searchBarXpath));
        logger.info("Ввод поискового запроса: " + request);
        driver.findElement(searchBarXpath).sendKeys(request + Keys.RETURN);
        return new SearchResultPage(browser);
    }

}
