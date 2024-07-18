package marcykiewicz.mateusz.charitydonationlab.institution;

import marcykiewicz.mateusz.charitydonationlab.institution.dto.InstitutionDTO;

import java.util.List;

public interface InstitutionService {

    InstitutionDTO save(InstitutionDTO institutionDTO);

    InstitutionDTO findById(Long id);

    List<InstitutionDTO> findAll();

    InstitutionDTO update(InstitutionDTO institutionDTO);

    InstitutionDTO deleteById(Long id);
}
