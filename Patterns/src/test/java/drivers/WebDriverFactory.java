package drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public static WebDriver getDriver(BrowserName name,String pageLoadStrategy) {
        switch (name) {
            // Драйвер браузера Google Chrome
            case CHROME:
                logger.info("Драйвер браузера Google Chrome");
                return ChromeBrowser.getDriver(pageLoadStrategy);
            // Драйвер браузера Mozilla Firefox
            case FIREFOX:
                logger.info("Драйвер браузера Mozilla Firefox");
                return FirefoxBrowser.getDriver(pageLoadStrategy);
            // Драйвер браузера Microsoft Edge
            default:
                throw new RuntimeException("Некорректное наименование браузера");
        }
    }
}
