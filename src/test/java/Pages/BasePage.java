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

    private Logger logger = LogManager.getLogger(Pages.BasePage.class);

    public BasePage(Browser browser){
        this.browser = browser;
        this.driver = browser.getDriver();
        this.wait = new WebDriverWait(driver,10);
    }
}
