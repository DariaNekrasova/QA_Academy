package application.FE.TimeMaster;

import application.FE.resourses.Locators;
import com.codeborne.selenide.SelenideElement;

import static application.FE.resourses.LocatorsSources.getLocator;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {


    SelenideElement input_email;
    SelenideElement input_password;
    SelenideElement button_submit;

    public LoginPage loginPage(){
        input_email = $(getLocator(Locators.MS_LOGIN_EMAIL));
        input_password = $(getLocator(Locators.MS_LOGIN_PASSWORD));
        button_submit = $(getLocator(Locators.MS_LOGIN_SUBMIT));
        return this;
    }

    public void setLogin(String name, String password){
        setEmail(name);
        submit();
        setPassword(password);
        submit();
    }

    private void setEmail(String email){
        input_email.setValue(email);
    }

    private void setPassword(String password){
        input_password.setValue(password);
    }

    private void submit(){
        button_submit.click();
    }
}
