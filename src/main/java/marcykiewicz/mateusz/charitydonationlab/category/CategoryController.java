package marcykiewicz.mateusz.charitydonationlab.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcykiewicz.mateusz.charitydonationlab.category.categorydto.CategoryDTO;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    private CategoryDTO findById(@PathVariable Long id) {

        return categoryService.findById(id);
    }

    @PostMapping
    private CategoryDTO save(@RequestBody CategoryDTO categoryDTO) {

        return categoryService.save(categoryDTO);
    }

    @PutMapping
    private CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO) {

        return categoryService.update(categoryDTO);
    }

    @DeleteMapping("/{id}")
    private CategoryDTO deleteById(@PathVariable Long id) {

        return categoryService.deleteById(id);
    }
}
