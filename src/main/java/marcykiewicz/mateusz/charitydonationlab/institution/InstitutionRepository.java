package marcykiewicz.mateusz.charitydonationlab.institution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    @Query(value = "SELECT i FROM Institution i LEFT JOIN FETCH i.donations WHERE i.id=:institutionId")
    Optional<Institution> findByIdFetchDonations(Long institutionId);
}
