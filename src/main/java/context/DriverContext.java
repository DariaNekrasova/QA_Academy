package context;

import com.codeborne.selenide.Configuration;
import com.sun.org.apache.xerces.internal.impl.PropertyManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import static java.util.Objects.isNull;

@Slf4j
public class DriverContext {

    public static WebDriver webDriver;

    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    public static void initializeDriver() {
        webDriver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MILLISECONDS);
        disableSelenideScreenshots();
    }

    public static void closeDriver(String specName, String scenarioName) {
        try {
            webDriver.quit();
        } catch (Throwable ignore) {
            log.warn("Failed to close web driver");
        }
    }

    public static boolean hasQuit() {
        return isNull(webDriver) || isNull(((RemoteWebDriver) webDriver).getSessionId());
    }

    private static void disableSelenideScreenshots() {
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
        Configuration.timeout = 20000;
        Configuration.collectionsTimeout = 20000;
    }
}
