package application.FE.context;

import application.Utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class ChromeLocalDriverFactory implements MvcDriverFactory {

    @Override
    public WebDriver create() {
        ChromeOptions options = new ChromeOptions();

        if (PropertyManager.getPropertyAsBoolean("HEADLESS_MODE", false))
            options.addArguments("--headless");

        return new ChromeDriver(options);
    }
}
