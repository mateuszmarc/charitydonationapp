package marcykiewicz.mateusz.charitydonationlab.donation;

import jakarta.persistence.*;
import lombok.Data;
import marcykiewicz.mateusz.charitydonationlab.category.Category;
import marcykiewicz.mateusz.charitydonationlab.institution.Institution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name= "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
    })
    @JoinTable(name = "donations_categories",
            joinColumns = @JoinColumn(name = "donation_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
    })
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "pick_up_date")
    private LocalDate pickUpDate;

    @Column(name = "pick_up_time")
    private LocalTime pickUpTime;

    @Column(name = "pick_up_comment")
    private String pickUpComment;

    public void addCategory(Category category) {
        categories.removeIf(c -> c.getId().equals(category.getId()));

        categories.add(category);
    }

    public void removeCategory(Category category) {

        categories.removeIf(c -> c.getId().equals(category.getId()));
    }
}
