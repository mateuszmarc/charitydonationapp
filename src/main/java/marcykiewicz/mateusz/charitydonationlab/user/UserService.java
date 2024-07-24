package marcykiewicz.mateusz.charitydonationlab.user;

import marcykiewicz.mateusz.charitydonationlab.user.userdto.UserDTO;

public interface UserService {

    UserDTO save(User user);

    UserDTO findByIdFetchDonations(Long id);

    UserDTO findByEmailFetchDonations(String email);

    UserDTO register(RegistrationRequest registrationRequest);

    void saveVerificationToken(User user, String verificationToken);

    String validateToken(String token);

}
