package Pages;

import Utils.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Browser browser;

    protected Logger logger = LogManager.getLogger(getClass());

    public BasePage(Browser browser){
        logger.info("Создан объект страницы");
        this.browser = browser;
        this.driver = browser.getDriver();
        this.wait = new WebDriverWait(driver,10);
    }
}
