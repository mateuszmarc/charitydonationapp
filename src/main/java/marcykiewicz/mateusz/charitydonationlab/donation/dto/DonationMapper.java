package marcykiewicz.mateusz.charitydonationlab.donation.dto;

import marcykiewicz.mateusz.charitydonationlab.donation.Donation;
import marcykiewicz.mateusz.charitydonationlab.institution.dto.InstitutionMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {InstitutionMapper.class})
public interface DonationMapper {

    @Mapping(source = "institutionDTO", target = "institution")
    Donation toEntity(DonationDTO donationDTO);

    @Mapping(source = "institution", target = "institutionDTO")
    DonationDTO toDTO(Donation donation);
}
