package marcykiewicz.mateusz.charitydonationlab.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String displayHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String displayLoginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterFrom() {
        return "register";
    }

    @GetMapping("/registerConfirmation")
    public String displayConfirmationForm() {
        return "form-confirmation";
    }
}
