package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//homework #2
public class WebDriverFactory {

    private WebDriver driver;
    private enum Browsers {CHROME , FIREFOX}
    private final Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public WebDriver create(String browserName) {                //создание webDriver без опций
        logger.info("Создание драйвера без дополнительных параметров " + browserName);

        switch (getBrowser(browserName).name().toUpperCase()){
            case ("FIREFOX"):                                           //заготовка для расширения пула браузеров
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:                                                    //если иного не задано, то запускаем хром
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        logger.info("Создан драйвер для " + browserName);
        return driver;
    }

    public WebDriver create(String browserName, ChromeOptions options) {     //создание webDriver с опциями для chrome
        logger.info("Создание драйвера c параметрами " + browserName);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        logger.info("Создан драйвер для " + browserName);
        return driver;
    }

    public WebDriver create(String browserName, FirefoxOptions options) {        //создание webDriver с опциями для firefox
        logger.info("Создание драйвера c параметрами " + browserName);
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
        logger.info("Создан драйвер для " + browserName);
        return driver;
    }

    private Browsers getBrowser(String browserName){
        Browsers browser = null;
        try{
            browser = Browsers.valueOf(browserName);
        }catch (IllegalArgumentException | NullPointerException ex){
            logger.error(ex.getMessage());
        } finally {
            return browser;
        }
    }

}
