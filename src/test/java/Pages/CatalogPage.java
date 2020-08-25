package Pages;

import Utils.Browser;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CatalogPage extends BasePage {

    private final By searchTitleXpath = By.xpath("//div[contains(@class, 'page-title')]/div[contains(@class, 'h1')]");

    public CatalogPage(Browser browser) {
        super(browser);
    }

    @Step("Проверка перехода в раздел {0}")
    public void verifySearchTitle(String expectedTitle){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchTitleXpath));
        String actualTitleText = driver.findElement(searchTitleXpath).getText();
        Assert.assertTrue(actualTitleText.contains(expectedTitle), "Переход произошёл в неуказанный раздел, ожидался " +
                expectedTitle + ", а фактически " + actualTitleText);
    }
}
