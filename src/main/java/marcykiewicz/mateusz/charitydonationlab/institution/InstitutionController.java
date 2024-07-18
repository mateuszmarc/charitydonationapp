package marcykiewicz.mateusz.charitydonationlab.institution;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marcykiewicz.mateusz.charitydonationlab.institution.dto.InstitutionDTO;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/institutions")
public class InstitutionController {

    private final InstitutionService institutionService;

    @GetMapping("/{id}")
    private InstitutionDTO findById(@PathVariable Long id) {

        return institutionService.findById(id);
    }

    @PostMapping
    private InstitutionDTO save(@RequestBody InstitutionDTO institutionDTO) {

        log.info("{}", institutionDTO);
        return institutionService.save(institutionDTO);
    }

    @PutMapping
    private InstitutionDTO updateInstitution(@RequestBody InstitutionDTO institutionDTO) {

        return institutionService.update(institutionDTO);
    }

    @DeleteMapping("/{id}")
    private InstitutionDTO deleteById(@PathVariable Long id) {

        return institutionService.deleteById(id);
    }
}
