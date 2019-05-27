package context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LoggingPreferences;

public class DriverFactory {

    public static WebDriver getDriver() {
        return factoryImplementation().create();
    }

    private static MvcDriverFactory factoryImplementation() {
            return new ChromeLocalDriverFactory();
    }

}
