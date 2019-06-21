package application.BE.TimeMaster;

import application.BE.AbstractController;
import application.BE.model.TimeMasterModeles.UserDto;
import application.Utils.PropertyManager;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;
import lombok.extern.slf4j.Slf4j;

import static application.BE.TimeMaster.Authorisation.autorisation;
import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class UserController extends AbstractController {

    String body = "{\"Username\":\"daria.nekrasova@sidenis.com\",\"Display\":\"daria.nekrasova@sidenis.com\",\"IfExistsResult\":0,\"ThrottleStatus\":0,\"Credentials\":{\"PrefCredential\":1,\"HasPassword\":true,\"RemoteNgcParams\":null,\"FidoParams\":null,\"SasParams\":null},\"EstsProperties\":{\"UserTenantBranding\":[{\"Locale\":0,\"BannerLogo\":\"https://secure.aadcdn.microsoftonline-p.com/c1c6b6c8-gmb3acqcsi7qbbfobqqrznziplv5moysshckbnrlfb0/logintenantbranding/0/bannerlogo?ts=636717571122934843\",\"TileLogo\":\"https://secure.aadcdn.microsoftonline-p.com/c1c6b6c8-gmb3acqcsi7qbbfobqqrznziplv5moysshckbnrlfb0/logintenantbranding/0/tilelogo?ts=635817949081057357\",\"TileDarkLogo\":\"https://secure.aadcdn.microsoftonline-p.com/c1c6b6c8-gmb3acqcsi7qbbfobqqrznziplv5moysshckbnrlfb0/logintenantbranding/0/squarelogodark?ts=635817949139957422\",\"UserIdLabel\":\"example@sidenis.com\",\"KeepMeSignedInDisabled\":false,\"UseTransparentLightBox\":false}],\"DomainType\":3},\"FlowToken\":\"AQABAAEAAADCoMpjJXrxTq9VG9te-7FX1gt61p1lJc95hpC846QzEB-O9WxumpKHs0jtPk4rIWW8itYM6yZkdLinBdUUkjBB7T-gCrjQ1w132NyipYf_L3r2FGIrrjTP7so7Gvjn-UORvWIqHETODFJiAYmNtH-I49OaniEK90RC5L5OOvhv5B5T56n7KtbG1FoAk_XkZ7PjICFPqdtik_G-bIR_TQnN8bH3b8Uzlwv_nGqALcwo0wqI4yuWcK6vifMQQPwSlCU2pWOF2Q9CrBk4wpQxKZCfc-vFCkYFyNAQ187J_0xuZEzgiFNQkXLbKbjewDfybaENlLrIV1wJd-8L-2s-IdudCLDNhj-7Ue-fvd3xf91qXt9OVSKuuFzeNEW_d7NaJxthj_k-FXHFTq9q9famn7vgIAA\",\"apiCanary\":\"AQABAAAAAADCoMpjJXrxTq9VG9te-7FXJph7Vh9jVnbGpvC8KM43rUJS2edw6PMNnJA1egmwbStVuxHxm8WEYkpAqATkDDrUA8IJKXF7M4T0oDuGliqMao2X0DbqEDbgpMSmmza4NQRichOFURd_ty92xDo7vmNETWO9c3xh3fkuvfcur-vPqKProzJEQJCrPl8nCpOcA-WuuVeRWwsfNC1Opzm_al3YFIck59YLKjxL64w2vCgmAiAA\"}";
    String micro_uri = "https://login.microsoftonline.com/common/GetCredentialType?mkt=ru-RU";
    String complete = "https://timemaster-dev2.sidenis.local/sso/complete/";

    String csrf;


    public UserController() {
        super(PropertyManager.getProperty("TM_URI"));
    }

    public String login(UserDto userDto) {
        //String uri = contextUri + "/api/login/";
        //String location =  post(uri).extract().header("Location");
        //post(micro_uri, body);
        //csrf = post(complete).extract().header("Cookie");
        //String[] cs = csrf.split("=[*.];");


        return "Ok";
    }

    public void login() {
        String uri = contextUri + "/api/logout";
        post(uri).extract().header("Location");
    }

    public void whoAmI() {
        String uri = contextUri + "/api/whoami/";
        //get(uri);
        String response = given().header(new Header("X-CSRFTOKEN", autorisation.getXCSRF()))
               .contentType(ContentType.JSON).when().then().response().toString();
        log.info("----------> " + response);

    }

    public void setAuth(String uri) {
        get(uri);
    }
}
