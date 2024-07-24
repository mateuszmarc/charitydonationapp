package marcykiewicz.mateusz.charitydonationlab.registration;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcykiewicz.mateusz.charitydonationlab.user.UserService;
import marcykiewicz.mateusz.charitydonationlab.user.userdto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;

    @GetMapping
    public String displayRegistrationForm(Model model) {

        model.addAttribute("request", new RegistrationRequestDTO());

        return "register";
    }

    @PostMapping
    public String registerUser(RegistrationRequestDTO registrationRequest, HttpServletRequest servletRequest) {

        log.info("{}", registrationRequest);

        registrationRequest.setRole("USER");

        UserDTO userDTO = userService.register(registrationRequest);

        return null;
    }
}
