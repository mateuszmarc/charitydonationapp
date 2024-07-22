package marcykiewicz.mateusz.charitydonationlab.donation.dto;

import jakarta.validation.constraints.Future;
import lombok.Data;
import marcykiewicz.mateusz.charitydonationlab.category.categorydto.CategoryDTO;
import marcykiewicz.mateusz.charitydonationlab.institution.dto.InstitutionDTO;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Future
    private LocalDate pickUpDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalTime pickUpTime;

    private String pickUpComment;

    private String phoneNumber;
}
