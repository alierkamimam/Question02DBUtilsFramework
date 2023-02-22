package utils;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static final int IMPLICIT_WAIT_TIME_IN_SECOND = 20;
    private static final int IMPLICIT_PAGE_LOAD_TIMEOUT = 20;

    public Driver() {
    }

    private static WebDriver driver;

    public static WebDriver getDriverReference() {
        return driver;

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (configReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_IN_SECOND, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
