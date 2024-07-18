package marcykiewicz.mateusz.charitydonationlab.category.categorydto;

import lombok.Data;
import marcykiewicz.mateusz.charitydonationlab.donation.dto.DonationDTO;

import java.util.List;

@Data
public class CategoryDTO {

    private Long id;

    private String name;

    private List<DonationDTO> donationDTOs;

}
