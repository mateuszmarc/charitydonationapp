package marcykiewicz.mateusz.charitydonationlab.institution.dto;

import marcykiewicz.mateusz.charitydonationlab.institution.Institution;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstitutionMapper {

    Institution toEntity(InstitutionDTO institutionDTO);

    InstitutionDTO toDTO(Institution institution);
}