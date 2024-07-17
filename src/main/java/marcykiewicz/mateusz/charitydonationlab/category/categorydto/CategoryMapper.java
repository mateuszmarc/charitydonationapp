package marcykiewicz.mateusz.charitydonationlab.category.categorydto;

import marcykiewicz.mateusz.charitydonationlab.category.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toEntity(CategoryDTO categoryDTO);

    CategoryDTO toDTO(Category category);
}
