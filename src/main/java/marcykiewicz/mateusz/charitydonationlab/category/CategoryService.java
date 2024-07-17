package marcykiewicz.mateusz.charitydonationlab.category;

import marcykiewicz.mateusz.charitydonationlab.category.categorydto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO save(CategoryDTO categoryDTO);

    CategoryDTO findById(Long id);

    List<CategoryDTO> findAll();

    CategoryDTO update(CategoryDTO categoryDTO);

    CategoryDTO deleteById(Long id);
}
