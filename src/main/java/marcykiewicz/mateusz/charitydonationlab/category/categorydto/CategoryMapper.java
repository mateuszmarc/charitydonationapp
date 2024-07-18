package marcykiewicz.mateusz.charitydonationlab.category.categorydto;

import marcykiewicz.mateusz.charitydonationlab.category.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryDTO categoryDTO);

    CategoryDTO toDTO(Category category);
}
