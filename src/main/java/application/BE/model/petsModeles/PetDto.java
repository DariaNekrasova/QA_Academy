package application.BE.model.petsModeles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PetDto {

    int id;
    PetCategoryDto[] category;
    String name;
    String[] photoUrls;
    PetTagDto[] tags;
    String status;


}

/**    {"id": 0,
        "category": {
            "id": 0,
            "name": "string"
        },
        "name": "doggie",
        "photoUrls": [
            "string"
        ],
        "tags": [
        {
            "id": 0,
            "name": "string"
        }
        ],
        "status": "available"
       }                       **/