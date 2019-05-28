package application.FE.context;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriver getDriver() {
        return factoryImplementation().create();
    }

    private static MvcDriverFactory factoryImplementation() {
            return new ChromeLocalDriverFactory();
    }

}
