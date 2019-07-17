package application.FE.context;

import org.openqa.selenium.WebDriver;

interface MvcDriverFactory {
    WebDriver create();
    WebDriver createWithoutHead();
}

