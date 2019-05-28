package application.FE.first_UI_steps;

import application.FE.Google.Google;
import application.FE.context.DriverFactory;
import com.codeborne.selenide.WebDriverRunner;
import com.thoughtworks.gauge.*;
import gauge.AbstractStep;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static application.FE.context.DriverContext.setup;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTestingSteps extends AbstractStep {

    WebDriver webDriver;

    @Step("Set webDriver")
    public void openBrowser() {
        setup();
        webDriver = DriverFactory.getDriver();
        webDriver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MILLISECONDS);

        WebDriverRunner.setWebDriver(webDriver);
    }

    @Step("Go to google")
    public void GoToGoogle() {
        open("https://www.google.com/");
        assertEquals( "https://www.google.com/", WebDriverRunner.currentFrameUrl(), "Current site is not google! =(");
    }

    @Step("Search <request>")
    public void searchInGoogle(String request) {
        Google googlePage = new Google();
        googlePage.searchField.setValue(request);
        googlePage.searchButton.click();
    }

    @AfterSpec
    public void teardownScenario() {
        WebDriverRunner.closeWebDriver();
    }
}
