package marcykiewicz.mateusz.charitydonationlab.category;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class CategoryServiceImpl implements CategoryService {

    @Value("${resourceNotFoundExceptionMessage}")
    private String resourceNotFoundExceptionMessage;

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final DonationMapper donationMapper;

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {

        Category category = categoryMapper.toEntity(categoryDTO);

        categoryRepository.save(category);

        return categoryMapper.toDTO(category);
    }

    @Override
    public CategoryDTO findById(Long id) {

        Optional<Category> optionalCategory = categoryRepository.findById(id);

        return optionalCategory.map(categoryMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(resourceNotFoundExceptionMessage.formatted(id)));
    }

    @Override
    public CategoryDTO findByIdFetchDonations(Long id) {

        Optional<Category> optionalCategory = categoryRepository.findByIdFetchDonations(id);

        return optionalCategory.map(
                        category -> {
                            List<DonationDTO> donationDTOs = category.getDonations().stream().map(donationMapper::toDTO).toList();

                            CategoryDTO categoryDTO = categoryMapper.toDTO(category);
                            categoryDTO.setDonationDTOs(donationDTOs);

                            return categoryDTO;
                        }
                )
                .orElseThrow(() -> new ResourceNotFoundException(resourceNotFoundExceptionMessage.formatted(id)));
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream().map(categoryMapper::toDTO).toList();
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {

        CategoryDTO foundCategoryDTO = findById(categoryDTO.getId());

        Category category = categoryMapper.toEntity(categoryDTO);

        Category updatedCategory = categoryRepository.save(category);

        return categoryMapper.toDTO(updatedCategory);
    }


    @Override
    public CategoryDTO deleteById(Long id) {

        CategoryDTO categoryDTO = findById(id);

        categoryRepository.deleteById(id);
        return categoryDTO;
    }
}
