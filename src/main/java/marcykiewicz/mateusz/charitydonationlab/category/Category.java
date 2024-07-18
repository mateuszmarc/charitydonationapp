package marcykiewicz.mateusz.charitydonationlab.category;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import marcykiewicz.mateusz.charitydonationlab.donation.Donation;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "categories", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    private List<Donation> donations = new ArrayList<>();


    public void addDonation(Donation donation) {

        donations.removeIf(d -> d.getId().equals(donation.getId()));

        donations.add(donation);
    }

    public void removeDonation(Donation donation) {

        donations.removeIf(d -> d.getId().equals(donation.getId()));
    }
}
