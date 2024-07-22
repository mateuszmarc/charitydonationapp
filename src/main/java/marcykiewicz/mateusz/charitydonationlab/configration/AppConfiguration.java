package marcykiewicz.mateusz.charitydonationlab.configration;

import lombok.RequiredArgsConstructor;
import marcykiewicz.mateusz.charitydonationlab.converters.CategoryDTOConverter;
import marcykiewicz.mateusz.charitydonationlab.converters.InstitutionDTOConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class AppConfiguration implements WebMvcConfigurer {

    private final CategoryDTOConverter categoryDTOConverter;
    private final InstitutionDTOConverter institutionDTOConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(categoryDTOConverter);
        registry.addConverter(institutionDTOConverter);
    }
}
