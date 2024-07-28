package marcykiewicz.mateusz.charitydonationlab.registration;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcykiewicz.mateusz.charitydonationlab.event.RegistrationCompleteEvent;
import marcykiewicz.mateusz.charitydonationlab.user.User;
import marcykiewicz.mateusz.charitydonationlab.user.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;
    private final ApplicationEventPublisher publisher;

    @GetMapping
    public String displayRegistrationForm(Model model) {

        model.addAttribute("request", new RegistrationRequestDTO());

        return "register";
    }

    @PostMapping
    @ResponseBody
    public String registerUser(RegistrationRequestDTO registrationRequest, HttpServletRequest servletRequest) {

        log.info("{}", registrationRequest);

        registrationRequest.setRole("USER");

        User user = userService.register(registrationRequest);

        publisher.publishEvent(new RegistrationCompleteEvent(user, getApplicationUrl(servletRequest)));

        return user.toString();
    }

    private String getApplicationUrl(HttpServletRequest httpServletRequest) {
        return "http://" + httpServletRequest.getServerName() + httpServletRequest.getServerPort() +
                httpServletRequest.getContextPath();
    }
}
