package marcykiewicz.mateusz.charitydonationlab.registration.token;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import marcykiewicz.mateusz.charitydonationlab.user.User;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Table(name = "verification_tokens")
public class VerificationToken {

    @Value("${tokenExpirationTime}")
    private int TOKEN_EXPIRATION_TIME;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "token")
    private String token;

    @Column(name = "expiration_time")
    private LocalDateTime expirationTime;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public VerificationToken(String token, User user) {
        this.token = token;
        this.user = user;
        this.expirationTime = getTokenExpirationTime();
    }


    private LocalDateTime getTokenExpirationTime() {
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime.plusMinutes(TOKEN_EXPIRATION_TIME);
    }
}
