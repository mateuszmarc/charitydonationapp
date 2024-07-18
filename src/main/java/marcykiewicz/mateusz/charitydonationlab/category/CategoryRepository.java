package marcykiewicz.mateusz.charitydonationlab.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT c FROM Category c LEFT JOIN FETCH c.donations WHERE c.id=:categoryId")
    Optional<Category> findByIdFetchDonations(Long categoryId);
}
