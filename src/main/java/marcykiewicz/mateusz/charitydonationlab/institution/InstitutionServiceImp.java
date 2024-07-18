package marcykiewicz.mateusz.charitydonationlab.institution;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @Value("${resourceNotFoundExceptionMessage}")
    private String resourceNotFoundExceptionMessage;

    private final InstitutionRepository institutionRepository;
    private final InstitutionMapper institutionMapper;

    @Override
    public InstitutionDTO save(InstitutionDTO institutionDTO) {

        log.info("DTO before mapping: {}", institutionDTO);

        Institution institution = institutionMapper.toEntity(institutionDTO);
        log.info("Entity after mapping: {}", institution);

        institutionRepository.save(institution);

        InstitutionDTO savedDTO = institutionMapper.toDTO(institution);

        log.info("DTO after saving: {}", savedDTO);
        return savedDTO;
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

        InstitutionDTO foundInstitutionDTO = findById(institutionDTO.getId());

        Institution institution = institutionMapper.toEntity(institutionDTO);

        Institution updatedinstitution = institutionRepository.save(institution);

        return institutionMapper.toDTO(updatedinstitution);
    }


    @Override
    public InstitutionDTO deleteById(Long id) {

        InstitutionDTO institutionDTO = findById(id);

        institutionRepository.deleteById(id);
        return institutionDTO;
    }
}
