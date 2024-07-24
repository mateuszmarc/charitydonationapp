package marcykiewicz.mateusz.charitydonationlab.user.userdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import marcykiewicz.mateusz.charitydonationlab.donation.Donation;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {


    private Long id;

    @NotNull
    private String firstName;

    private String lastName;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size
    private String password;

    private String phoneNumber;

    private String address;

    private List<Donation> donations = new ArrayList<>();
}
