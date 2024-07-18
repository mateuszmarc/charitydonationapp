package marcykiewicz.mateusz.charitydonationlab.institution.dto;

import lombok.Data;
import marcykiewicz.mateusz.charitydonationlab.donation.dto.DonationDTO;

import java.util.List;

@Data
public class InstitutionDTO {

    private Long id;

    private String name;

    private String description;

    private List<DonationDTO> donationDTOs;
}
