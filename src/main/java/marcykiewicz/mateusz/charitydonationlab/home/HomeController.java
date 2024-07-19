package marcykiewicz.mateusz.charitydonationlab.home;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcykiewicz.mateusz.charitydonationlab.institution.InstitutionService;
import marcykiewicz.mateusz.charitydonationlab.institution.dto.InstitutionDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

    private final InstitutionService institutionService;

    @GetMapping("/home")
    public String displayHomePage(Model model) {

        List<List<InstitutionDTO>> institutionDTOs = institutionService.findAllInstitutionsGroupedBYTwo();

        log.info("{}", institutionDTOs);

        model.addAttribute("institutions", institutionDTOs);

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
