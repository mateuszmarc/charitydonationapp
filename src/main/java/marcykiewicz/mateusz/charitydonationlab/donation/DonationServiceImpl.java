package marcykiewicz.mateusz.charitydonationlab.donation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcykiewicz.mateusz.charitydonationlab.category.CategoryRepository;
import marcykiewicz.mateusz.charitydonationlab.category.categorydto.CategoryDTO;
import marcykiewicz.mateusz.charitydonationlab.category.categorydto.CategoryMapper;
import marcykiewicz.mateusz.charitydonationlab.donation.dto.DonationDTO;
import marcykiewicz.mateusz.charitydonationlab.donation.dto.DonationMapper;
import marcykiewicz.mateusz.charitydonationlab.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class DonationServiceImpl implements DonationService {

    @Value("${resourceNotFoundExceptionMessage}")
    private String resourceNOtFoundExceptionMessage;

    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;
    private final DonationMapper donationMapper;
    private final CategoryMapper categoryMapper;

    @Override
    public List<DonationDTO> findAll() {

        List<Donation> donations = donationRepository.findAll();

        return donations.stream().map(donationMapper::toDTO).toList();
    }

    @Override
    public DonationDTO findById(Long id) {

        Optional<Donation> optionalDonation = donationRepository.findById(id);

        return optionalDonation.map(donationMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(resourceNOtFoundExceptionMessage.formatted(id)));
    }

    @Override
    public DonationDTO findByIdFetchCategories(Long id) {
        Optional<Donation> optionalDonation = donationRepository.findByIdFetchCategories(id);

        return optionalDonation.map(donation -> {

                    List<CategoryDTO> categoriesDTO = donation.getCategories().stream().map(categoryMapper::toDTO).toList();

                    DonationDTO donationDTO = donationMapper.toDTO(donation);

                    donationDTO.setCategoryDTOs(categoriesDTO);

                    return donationDTO;
                })
                .orElseThrow(() -> new ResourceNotFoundException(resourceNOtFoundExceptionMessage.formatted(id)));
    }

    @Override
    public DonationDTO save(DonationDTO donationDTO) {

        Donation donation = donationMapper.toEntity(donationDTO);

        donationRepository.save(donation);

        return donationMapper.toDTO(donation);
    }

    @Override
    public DonationDTO update(DonationDTO donationDTO) {

        Optional<Donation> optionalDonation = donationRepository.findByIdFetchCategories(donationDTO.getId());

        return optionalDonation.map(donation -> {

                    Donation updatedDonation = donationMapper.toEntity(donationDTO);

                    donationRepository.save(updatedDonation);

                    return donationMapper.toDTO(updatedDonation);
                })
                .orElseThrow(() -> new ResourceNotFoundException(resourceNOtFoundExceptionMessage.formatted(donationDTO.getId())));
    }

    @Override
    public DonationDTO removeById(Long id) {

        Optional<Donation> optionalDonation = donationRepository.findByIdFetchCategories(id);

        return optionalDonation.map(donation -> {

                    donation.getCategories().forEach(category -> {

                        category.removeDonation(donation);
                        categoryRepository.save(category);
                    });

                    donationRepository.delete(donation);
                    return donationMapper.toDTO(donation);
                })
                .orElseThrow(() -> new ResourceNotFoundException(resourceNOtFoundExceptionMessage.formatted(id)));
    }
}
