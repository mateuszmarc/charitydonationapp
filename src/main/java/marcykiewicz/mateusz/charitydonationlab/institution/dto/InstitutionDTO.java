package marcykiewicz.mateusz.charitydonationlab.institution.dto;

import lombok.Data;
import marcykiewicz.mateusz.charitydonationlab.donation.dto.DonationDTO;

@Data
public class InstitutionDTO {

    private Long id;

    private String name;

    private String description;

    private DonationDTO donationDTO;
}
