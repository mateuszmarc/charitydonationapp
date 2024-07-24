package marcykiewicz.mateusz.charitydonationlab.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import marcykiewicz.mateusz.charitydonationlab.donation.Donation;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @Size
    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "app_user_role")
    private String appUserRole;

    @Column(name = "enabled")
    private Boolean enabled = false;

    @OneToMany(mappedBy = "user")
    private List<Donation> donations = new ArrayList<>();

    public User(String email, String password, String appUserRole) {
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
    }

    public void addDonation(Donation donation) {

        donations.removeIf(donation1 -> donation1.getId().equals(donation.getId()));
        donations.add(donation);
    }

    public void removeDonation(Donation donation) {

        donations.removeIf(donation1 -> donation1.getId().equals(donation.getId()));
    }

}
