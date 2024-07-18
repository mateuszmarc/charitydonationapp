package marcykiewicz.mateusz.charitydonationlab.institution;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcykiewicz.mateusz.charitydonationlab.donation.Donation;
import marcykiewicz.mateusz.charitydonationlab.donation.DonationRepository;
import marcykiewicz.mateusz.charitydonationlab.exception.ResourceNotFoundException;
import marcykiewicz.mateusz.charitydonationlab.institution.dto.InstitutionDTO;
import marcykiewicz.mateusz.charitydonationlab.institution.dto.InstitutionMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class InstitutionServiceImp implements InstitutionService {

    private final DonationRepository donationRepository;
    @Value("${resourceNotFoundExceptionMessage}")
    private String resourceNotFoundExceptionMessage;

    private final InstitutionRepository institutionRepository;
    private final InstitutionMapper institutionMapper;

    @Override
    public InstitutionDTO save(InstitutionDTO institutionDTO) {

        List<Donation> donations = institutionDTO.getDonationDTOs().stream().map(
                donationDTO -> donationRepository.findById(donationDTO.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Donation with id: %s not found".formatted(donationDTO.getId())))
        ).toList();

        Institution institution = institutionMapper.toEntity(institutionDTO);
        institution.setDonations(donations);

        Institution savedInstitution = institutionRepository.save(institution);

        InstitutionDTO savedInstitutionDTO = institutionMapper.toDTO(savedInstitution);

        savedInstitutionDTO.setDonationDTOs(institutionDTO.getDonationDTOs());

        return savedInstitutionDTO;
    }

    @Override
    public InstitutionDTO findById(Long id) {

        Optional<Institution> optionalInstitution = institutionRepository.findById(id);

        return optionalInstitution.map(institutionMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(resourceNotFoundExceptionMessage.formatted(id)));
    }

    @Override
    public List<InstitutionDTO> findAll() {
        List<Institution> categories = institutionRepository.findAll();

        return categories.stream().map(institutionMapper::toDTO).toList();
    }

    @Override
    public InstitutionDTO update(InstitutionDTO institutionDTO) {

        Institution existingInstitution = institutionRepository.findByIdFetchDonations(institutionDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Institution with id: %s not found".formatted(institutionDTO.getId())));

        log.info("Institution to update {}", existingInstitution);

        List<Donation> donations = institutionDTO.getDonationDTOs().stream().map(donationDTO -> donationRepository.findById(donationDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Donation with id: %s not found".formatted(donationDTO.getId())))).toList();

        log.info("Donations from updated Institution {}", donations);

        existingInstitution.setName(institutionDTO.getName());
        existingInstitution.setDescription(institutionDTO.getDescription());


//        log.info("Before clear");
//        existingInstitution.getDonations().clear();
//        log.info("After clear");
//
//        existingInstitution.setDonations(donations);
//
//        log.info("Entity with updated donations: {}", existingInstitution);
//
        Institution updatedInstitution = institutionRepository.save(existingInstitution);
//
//        log.info("Institution updated");

        InstitutionDTO updatedInstitutionDTO = institutionMapper.toDTO(updatedInstitution);


        updatedInstitutionDTO.setDonationDTOs(institutionDTO.getDonationDTOs());

        return updatedInstitutionDTO;
    }


    @Override
    public InstitutionDTO deleteById(Long id) {

        Institution institution = institutionRepository.findByIdFetchDonations(id)
                .orElseThrow(() -> new ResourceNotFoundException("Institution with id: %s not found".formatted(id)));

        institution.getDonations().forEach(donation -> {
            donation.setInstitution(null);
            donationRepository.save(donation);
        });

        institutionRepository.deleteById(id);
        return institutionMapper.toDTO(institution);
    }
}
