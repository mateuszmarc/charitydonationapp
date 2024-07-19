package marcykiewicz.mateusz.charitydonationlab.donation;

import marcykiewicz.mateusz.charitydonationlab.donation.dto.DonationDTO;

import java.util.List;

public interface DonationService {

    List<DonationDTO> findAll();

    DonationDTO findById(Long id);

    DonationDTO findByIdFetchCategories(Long id);

    DonationDTO save(DonationDTO donationDTO);

    DonationDTO update(DonationDTO donationDTO);

    DonationDTO removeById(Long id);

    Integer getSumOfQuantities();

    Integer getDonationCount();
}
