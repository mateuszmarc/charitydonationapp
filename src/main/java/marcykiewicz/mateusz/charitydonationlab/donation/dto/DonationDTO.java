package marcykiewicz.mateusz.charitydonationlab.donation.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @Min(value = 1)
    private Integer quantity;

    @NotEmpty
    private List<CategoryDTO> categoryDTOs = new ArrayList<>();

    @NotNull
    private InstitutionDTO institutionDTO;

    @NotNull
    private String street;

    @NotNull
    private String city;

    @NotNull
    private String zipCode;

    @NotNull
    @Future
    private LocalDate pickUpDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalTime pickUpTime;

    private String pickUpComment;

    @NotNull
    private String phoneNumber;
}
