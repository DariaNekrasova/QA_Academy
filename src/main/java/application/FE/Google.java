package application.FE;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Google {

    public final static String BASE_URL = "https://www.google.com";

    public SelenideElement searchField;
    public SelenideElement searchButton;
    public SelenideElement luckyButton;
    public SelenideElement mail;
    public SelenideElement pictures;

    public Google(){
        searchField = $("input.gLFyf");
        searchButton = $("input.gNO89b");
        luckyButton = $(By.name("btnI"));
    }
}
