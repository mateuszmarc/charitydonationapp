package marcykiewicz.mateusz.charitydonationlab.converters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcykiewicz.mateusz.charitydonationlab.institution.InstitutionService;
import marcykiewicz.mateusz.charitydonationlab.institution.dto.InstitutionDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class InstitutionDTOConverter implements Converter<String, InstitutionDTO> {

    private final InstitutionService institutionService;

    @Override
    public InstitutionDTO convert(String source) {
        log.info("institution id: {}", source);
        return institutionService.findById(Long.parseLong(source));
    }
}
