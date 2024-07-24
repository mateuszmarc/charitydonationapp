package marcykiewicz.mateusz.charitydonationlab.registration;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistrationRequestDTO {

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String passwordRepeat;

    private String role;

}
