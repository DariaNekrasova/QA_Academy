package application.BE.TimeMaster;

import application.FE.TimeMaster.LoginPage;
import application.FE.context.DriverFactory;
import application.Utils.PropertyManager;
import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static application.FE.context.DriverContext.setup;
import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class Authorisation {

    private WebDriver driver;

    private static final String TM_URI = "https://timemaster-dev2.sidenis.local";
    private static final String MS_URI = "https://login.microsoftonline.com";

    static final Authorisation autorisation = new Authorisation();

    private String CSRFToken;

    private Authorisation(){setDriver();auth();}

    public String getXCSRF(){
        return CSRFToken;
    }

    void auth(){
        driver.get(TM_URI);
        sleep(5000);

        log.info("should be MS site -> " + driver.getCurrentUrl());

        LoginPage login = new LoginPage();
        log.info("user name -> "+ System.getProperty("user_name") + "  password -> " + System.getProperty("user_password"));

        login.setLogin(System.getProperty("user_name"), System.getProperty("user_password"));

        sleep(5000);
        //assertThat(driver.getCurrentUrl()).contains(TM_URI);

        log.info("should be TM site -> " + driver.getCurrentUrl());


        CSRFToken = driver.manage().getCookies().stream().filter(cookie -> cookie.getName().equals("csrftoken")).findFirst().get().getValue();

        log.info("token -> " + CSRFToken);
    }

    private void setDriver(){
        setup();
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MILLISECONDS);
        WebDriverRunner.setWebDriver(driver);
    }
}
