package marcykiewicz.mateusz.charitydonationlab.converters;

import lombok.RequiredArgsConstructor;
import marcykiewicz.mateusz.charitydonationlab.category.CategoryService;
import marcykiewicz.mateusz.charitydonationlab.category.categorydto.CategoryDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryDTOConverter implements Converter<String, CategoryDTO> {

    private final CategoryService categoryService;


    @Override
    public CategoryDTO convert(String source) {
        return categoryService.findById(Long.parseLong(source));
    }
}
