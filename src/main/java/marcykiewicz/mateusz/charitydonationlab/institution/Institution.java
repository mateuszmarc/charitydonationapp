package marcykiewicz.mateusz.charitydonationlab.institution;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "institutions")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
