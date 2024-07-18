package marcykiewicz.mateusz.charitydonationlab.donation.dto;

import marcykiewicz.mateusz.charitydonationlab.donation.Donation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DonationMapper {

    Donation toEntity(DonationDTO donationDTO);

    DonationDTO toDTO(Donation donation);
}
