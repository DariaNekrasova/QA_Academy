package application.FE.context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class ChromeLocalDriverFactory implements MvcDriverFactory {

    @Override
    public WebDriver create() {
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }
}
