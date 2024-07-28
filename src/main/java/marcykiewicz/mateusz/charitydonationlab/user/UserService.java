package marcykiewicz.mateusz.charitydonationlab.user;

import marcykiewicz.mateusz.charitydonationlab.registration.RegistrationRequestDTO;
import marcykiewicz.mateusz.charitydonationlab.user.userdto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO save(User user);

    UserDTO findByIdFetchDonations(Long id);

    UserDTO findByEmailFetchDonations(String email);

    User register(RegistrationRequestDTO registrationRequestDTO);

    void saveVerificationToken(User user, String verificationToken);

    String validateToken(String token);

}
