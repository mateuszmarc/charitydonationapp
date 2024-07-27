package marcykiewicz.mateusz.charitydonationlab.registration.token;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<Long, VerificationToken> {

    VerificationToken findByToken(String token);

}
