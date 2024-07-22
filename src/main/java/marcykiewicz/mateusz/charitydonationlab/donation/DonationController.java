package marcykiewicz.mateusz.charitydonationlab.donation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcykiewicz.mateusz.charitydonationlab.category.CategoryService;
import marcykiewicz.mateusz.charitydonationlab.category.categorydto.CategoryDTO;
import marcykiewicz.mateusz.charitydonationlab.donation.dto.DonationDTO;
import marcykiewicz.mateusz.charitydonationlab.institution.InstitutionService;
import marcykiewicz.mateusz.charitydonationlab.institution.dto.InstitutionDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/donations")
public class DonationController {

   private final DonationService donationService;
   private final CategoryService categoryService;
   private final InstitutionService institutionService;

    @GetMapping("/donate")
    public String showDonationForm(Model model) {

        List<CategoryDTO> categoryDTOs = categoryService.findAll();
        List<InstitutionDTO> institutionDTOs = institutionService.findAll();

        log.info("{}", categoryDTOs);

        model.addAttribute("donationDTO", new DonationDTO());;
        model.addAttribute("categories", categoryDTOs);
        model.addAttribute("institutions", institutionDTOs);

        return "form";
    }

    @PostMapping("/donate")
    public String processDonationForm(@Valid @ModelAttribute DonationDTO donationDTO,
                                      BindingResult bindingResult
                                      ) {

        log.info("{}", donationDTO);

        if (bindingResult.hasErrors()) {
            return "form";
        }

        donationService.save(donationDTO);
        return "form-confirmation";
    }
}
