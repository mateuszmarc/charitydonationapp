package marcykiewicz.mateusz.charitydonationlab.institution.dto;

import marcykiewicz.mateusz.charitydonationlab.institution.Institution;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InstitutionMapper {

    InstitutionMapper INSTANCE = Mappers.getMapper(InstitutionMapper.class);

    Institution toEntity(InstitutionDTO institutionDTO);

    InstitutionDTO toDTO(Institution institution);
}