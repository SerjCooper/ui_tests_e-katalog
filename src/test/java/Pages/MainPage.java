package Pages;

import Utils.Browser;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    private Actions actions;

    private final By searchBarXpath = By.xpath("//input[contains(@id,'ek-search')]");
    private final By mainMenuXpath = By.xpath("//ul[contains(@class,'mainmenu-list')]");


    private String sectionParamXpath = "//li[contains(@class, 'mainmenu-item')]/a[contains(text(), '%s')]";
    //private String categoryParamXpath = "//li[contains(@class, 'mainmenu-item')]//a[contains(text(), '%c')]";
    //private String categoryParamLinkText = "//li[contains(@class, 'mainmenu-item')]//a[contains(text(), '%c')]";

    public MainPage(Browser browser) {
        super(browser);
    }

    @Step("Ввод и поиск по запросу {0}")
    public SearchResultPage search(String request) {
        wait.until(ExpectedConditions.elementToBeClickable(searchBarXpath));
        logger.info("Ввод поискового запроса: " + request);
        driver.findElement(searchBarXpath).sendKeys(request + Keys.RETURN);
        return new SearchResultPage(browser);
    }

    @Step("Переход в раздел {0} и категорию {1}")
    public CatalogPage goToCategory(String sectionName, String categoryName){
        By sectionXpath = By.xpath(sectionParamXpath.replace("%s", sectionName));
        By categoryLinkText = By.linkText(categoryName);

        wait.until(ExpectedConditions.elementToBeClickable(sectionXpath));

        actions = new Actions(driver);

        WebElement section = driver.findElement(sectionXpath);

        actions.moveToElement(section).perform();
        wait.until(ExpectedConditions.elementToBeClickable(categoryLinkText));
        driver.findElement(categoryLinkText).click();
        return new CatalogPage(browser);
    }

}
