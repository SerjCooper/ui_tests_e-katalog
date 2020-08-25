package Tests;

import Config.ServerConfig;
import Utils.Browser;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BaseTest {

    protected Logger logger = LogManager.getLogger(getClass());
    protected ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    protected Browser browser;

    @BeforeTest
    public void setUp(){
        logger.info("Инициализация теста" );
        this.browser = new Browser();
        browser.setUp();
    }

    @AfterTest
    public void quit(){
        browser.quit();
        this.browser = null;
    }
}
