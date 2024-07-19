package marcykiewicz.mateusz.charitydonationlab.donation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/donations")
public class DonationController {

   private final DonationService donationService;

    @GetMapping("/donate")
    public String showDonationForm(Model model) {

        model.addAttribute("donation", new Donation());

        return "form";
    }
}
