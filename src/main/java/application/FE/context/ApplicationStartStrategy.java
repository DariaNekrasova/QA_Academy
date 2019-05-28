package application.FE.context;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Selenide.open;

public class ApplicationStartStrategy {

    public void start(String base_url) {
        setWebDriver();
        openBrowser(base_url);
    }

    private void setWebDriver() {
        WebDriver currentWebDriver = DriverContext.webDriver;
        //try {
        //    currentWebDriver.manage().window().maximize();
        //} catch (Exception exc) {
        //    Dimension dimension = getMaxDimension();
        //    currentWebDriver.manage().window().setSize(dimension);
        //}
        WebDriverRunner.setWebDriver(currentWebDriver);
    }

    private void openBrowser(String base_url) {
        open(base_url);
    }


    private Dimension getMaxDimension() {
        int width = 1280;
        int height = 1024;
        return new Dimension(width, height);
    }
}
