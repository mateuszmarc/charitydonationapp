package marcykiewicz.mateusz.charitydonationlab.donation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcykiewicz.mateusz.charitydonationlab.donation.dto.DonationDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/donations")
public class DonationController {

    private final DonationService donationService;

    @GetMapping
    private List<DonationDTO> findAllDonations() {

        return donationService.findAll();
    }

    @GetMapping("/{id}")
    public DonationDTO findById(@PathVariable Long id) {

        return  donationService.findById(id);
    }

    @PostMapping
    public DonationDTO saveDonation(@RequestBody DonationDTO donationDTO) {

        return donationService.save(donationDTO);
    }

    @PutMapping
    public DonationDTO updateDonation(@RequestBody DonationDTO donationDTO) {

       return donationService.update(donationDTO);
    }

    @DeleteMapping("/{id}")
    public DonationDTO removeDonationById(@PathVariable Long id) {

        return donationService.removeById(id);
    }
}
