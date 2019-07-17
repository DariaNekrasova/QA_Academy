package application.BE.TimeMaster;

import application.BE.model.TimeMasterModeles.UserDto;
import application.BE.model.TimeMasterModeles.WhoAmIDto;
import com.thoughtworks.gauge.Step;
import gauge.AbstractStep;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserControllerSteps extends AbstractStep {

    private UserController userController = new UserController();

    @Step("Login with name <name> and password <pass>")
    public void login(String name, String pass){
        UserDto user = UserDto.builder().username(name).password(pass).build();
        String Location = userController.login(user);
        userController.setAuth(Location);
        userController.whoAmI();
    }

    @Step("Who Am I")
    public void who(){
        WhoAmIDto who = userController.whoAmI();
        log.info(who.toString());
    }
}
