package application.FE.resourses;

import java.util.HashMap;
import java.util.Map;

public class LocatorsSources {

    public static final LocatorsSources locators = new LocatorsSources();
    Map<String, String> locatorsMap;

    public LocatorsSources() {createMap();}

    public static String getLocator(Locators name){
        return locators.locatorsMap.get(name.name());
    }

    private static void createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("MS_LOGIN_EMAIL", "input[type = \"email\"]");
        map.put("MS_LOGIN_PASSWORD", "input[@name='passwd']");
        map.put("MS_LOGIN_SUBMIT","input[type = \"submit\"]");
    }
}
