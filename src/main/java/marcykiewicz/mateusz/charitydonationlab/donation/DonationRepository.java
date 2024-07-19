package marcykiewicz.mateusz.charitydonationlab.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT d FROM Donation d LEFT JOIN FETCH d.categories WHERE d.id=:donationId")
    Optional<Donation> findByIdFetchCategories(Long donationId);

    @Query(value = "SELECT SUM(d.quantity) FROM Donation d")
    Integer getSumOfDonationBags();

    @Query(value = "SELECT COUNT(d) FROM Donation  d")
    Integer getDonationsCount();
}
