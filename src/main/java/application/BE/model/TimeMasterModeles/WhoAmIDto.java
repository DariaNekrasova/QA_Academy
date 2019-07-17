package application.BE.model.TimeMasterModeles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class WhoAmIDto {

    String date_joined;
    String email;
    String full_name;
    Integer id;
    Boolean is_active;
    Boolean is_anonymous;
    Boolean is_staff;
    Boolean is_superuser;
    String uid;
    //~user_permissions
}
