package marcykiewicz.mateusz.charitydonationlab.institution.dto;

import marcykiewicz.mateusz.charitydonationlab.donation.dto.DonationMapper;
import marcykiewicz.mateusz.charitydonationlab.institution.Institution;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DonationMapper.class})
public interface InstitutionMapper {

    @Mapping(source = "donationDTO", target = "donation")
    Institution toEntity(InstitutionDTO institutionDTO);

    @Mapping(source = "donation", target = "donationDTO")
    InstitutionDTO toDTO(Institution institution);
}