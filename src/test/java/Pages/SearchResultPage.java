package Pages;

import Utils.Browser;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SearchResultPage extends BasePage {

    private final By searchTitleXpath = By.xpath("//div[contains(@class, 'page-title')]/h1");

    public SearchResultPage(Browser browser) {
        super(browser);
    }

    @Step("Проверка совпадения поискового по {0} с заголовком результатов выборки")
    public void verifySearchTitle(String expectedTitle){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchTitleXpath));
        String actualTitleText = driver.findElement(searchTitleXpath).getText();
        Assert.assertTrue(actualTitleText.contains(expectedTitle), "Текст исходного запроса " +
                "не совпадает с заголовком страницы с результатами поиска");
    }
}
