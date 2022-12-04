package tests;

import drivers.BrowserName;
import drivers.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;

public class BaseTest {
    protected static WebDriver driver;
    String envPageLoadStrategy = System.getProperty("loadstrategy", "normal");
    private Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeEach
    public void setUp() {
        String browser = System
                .getProperty("browser","chrome")
                .toLowerCase();
        logger.info("env = " + BrowserName.fromString(browser) + " + " + envPageLoadStrategy);
        driver = WebDriverFactory.getDriver(BrowserName.fromString(browser), envPageLoadStrategy.toLowerCase());
        logger.info("Драйвер стартовал!");
    }

    @AfterEach
    public void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }

}
