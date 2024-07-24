package marcykiewicz.mateusz.charitydonationlab.user;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcykiewicz.mateusz.charitydonationlab.exception.UserAlreadyExistsException;
import marcykiewicz.mateusz.charitydonationlab.registration.RegistrationRequestDTO;
import marcykiewicz.mateusz.charitydonationlab.user.userdto.UserDTO;
import marcykiewicz.mateusz.charitydonationlab.user.userdto.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@RequiredArgsConstructor
@Slf4j
@Transactional
@Service
public class UserServiceImpl implements UserService {

    private static final String USER_ALREADY_EXISTS_MESSAGE = "User with email '%s' already exists.";

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();

        return users.stream().map(userMapper::toDTO).toList();
    }

    @Override
    public UserDTO save(User user) {
        return null;
    }

    @Override
    public UserDTO findByIdFetchDonations(Long id) {
        return null;
    }

    @Override
    public UserDTO findByEmailFetchDonations(String email) {
        return null;
    }

    @Override
    public UserDTO register(RegistrationRequestDTO registrationRequestDTO) {
        Optional<User> foundUser = userRepository.findByEmail(registrationRequestDTO.getEmail());

        if (foundUser.isPresent()) {
            throw new UserAlreadyExistsException(USER_ALREADY_EXISTS_MESSAGE.formatted(registrationRequestDTO.getEmail()));
        }

        User user = new User(
                registrationRequestDTO.getEmail(),
                passwordEncoder.encode(registrationRequestDTO.getPassword()),
                registrationRequestDTO.getRole()
        );


        User savedUser = userRepository.save(user);

        return userMapper.toDTO(user);
    }

    @Override
    public void saveVerificationToken(User user, String verificationToken) {

    }

    @Override
    public String validateToken(String token) {
        return "";
    }
}
