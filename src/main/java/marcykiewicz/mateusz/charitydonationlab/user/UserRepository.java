package marcykiewicz.mateusz.charitydonationlab.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u LEFT JOIN FETCH u.donations WHERE u.id=:userId")
    Optional<User> findByIdJoinFetchDonations(Long userId);

    @Query(value = "SELECT u FROM User u LEFT JOIN FETCH u.donations WHERE u.email=:userEmail")
    Optional<User> findByEmailJoinFetchDonations(String userEmail);

    @Query(value = "SELECT u FROM User u WHERE u.email=:userEmail")
    Optional<User> findByEmail(String email);
}
