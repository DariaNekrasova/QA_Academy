package application.FE.TimeMaster;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Slf4j
public class LoginPage {


    SelenideElement input_email;
    SelenideElement input_password;
    SelenideElement button_submit;

    public LoginPage() {
        //input_email = $(getLocator("123"));
        button_submit = $("input[type = \"submit\"]");
    }

    public void setLogin(String name, String password){
        setEmail(name);
        submit();
        sleep(2000);
        setPassword(password);
        submit();
        sleep(2000);
        submit();
    }

    private void setEmail(String email){
        input_email = $("input[type = 'email']");
        log.info("setting email " + email);
        input_email.setValue(email);
    }

    private void setPassword(String password){
        input_password = $("input[name='passwd']");
        log.info("setting password " + password);
        input_password.setValue(password);
    }

    private void submit(){
        log.info("click on the button");
        button_submit.click();
    }
}
