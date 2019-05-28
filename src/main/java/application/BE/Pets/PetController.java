package application.BE.Pets;

import application.BE.AbstractController;
import application.BE.DtoUtils;
import application.BE.model.petsModeles.PetCategoryDto;
import application.BE.model.petsModeles.PetDto;
import com.google.inject.Inject;

import static java.text.MessageFormat.format;

public class PetController extends AbstractController {

    private final String BASE_URL = "https://petstore.swagger.io/v2";

    public PetController() {
        super("https://petstore.swagger.io/v2");
    }

    public void addNewPet(PetDto petDto){
        String uri = format("{0}/pet", BASE_URL);
        post(uri, DtoUtils.toJSON(petDto));
    }

    public PetCategoryDto getPetById(int id){
        String uri = format( "{0}/pet/{1,number,#}", BASE_URL, id);
        return get(uri, PetCategoryDto.class);
    }
}
