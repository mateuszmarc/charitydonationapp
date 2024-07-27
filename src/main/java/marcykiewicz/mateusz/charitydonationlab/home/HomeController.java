package marcykiewicz.mateusz.charitydonationlab.home;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcykiewicz.mateusz.charitydonationlab.donation.DonationService;
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
    private final DonationService donationService;

    @GetMapping("/home")
    public String displayHomePage(Model model) {

        List<List<InstitutionDTO>> institutionDTOs = institutionService.findAllInstitutionsGroupedBYTwo();
        Integer donatedBags = donationService.getSumOfQuantities();
        Integer donationCount = donationService.getDonationCount();

        log.info("{}", institutionDTOs);
        log.info("{}", donatedBags);
        log.info("{}", donationCount);

        model.addAttribute("institutions", institutionDTOs);
        model.addAttribute("donatedBags", donatedBags);
        model.addAttribute("donationCount", donationCount);
        return "index";
    }

    @GetMapping("/login")
    public String displayLoginForm() {
        return "login";
    }

    @GetMapping("/registerConfirmation")
    public String displayConfirmationForm() {
        return "form-confirmation";
    }
}
