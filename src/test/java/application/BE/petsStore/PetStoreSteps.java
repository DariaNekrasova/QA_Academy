package application.BE.petsStore;

import application.BE.Pets.PetController;
import application.BE.model.petsModeles.PetCategoryDto;
import application.BE.model.petsModeles.PetDto;
import com.thoughtworks.gauge.Step;
import gauge.AbstractStep;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetStoreSteps extends AbstractStep {

    private PetController petController = new PetController();

    @Step("Add new pet with id <id> and name <name>")
    public void addnewPet(int id, String name) {
        PetDto pet = new PetDto();
        pet.setName(name);
        pet.setId(id);
        System.out.println(pet);
        petController.addNewPet(pet);
    }

    @Step("Get name of pet with id <id>")
    public void getPetName(int id) {
        PetCategoryDto pet;
        pet = petController.getPetById(id);
        System.out.println("Pet name is - " + pet.getName());
    }

    @Step("Is name of pet with id <id> - <name>")
    public void isPetNameCorrect(int id, String name) {
        PetCategoryDto pet;
        pet = petController.getPetById(id);
        assertEquals(pet.getName(), name);
    }
}
