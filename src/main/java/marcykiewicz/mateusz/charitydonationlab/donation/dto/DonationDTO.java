package marcykiewicz.mateusz.charitydonationlab.donation.dto;

import lombok.Data;
import marcykiewicz.mateusz.charitydonationlab.category.categorydto.CategoryDTO;
import marcykiewicz.mateusz.charitydonationlab.institution.dto.InstitutionDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class DonationDTO {

    private Long id;

    private Integer quantity;

    private List<CategoryDTO> categoryDTOs = new ArrayList<>();

    private InstitutionDTO institutionDTO;

    private String street;

    private String city;

    private String zipCode;

    private LocalDate pickUpDate;

    private LocalTime pickUpTime;

    private String pickUpComment;

    private String phoneNumber;
}
