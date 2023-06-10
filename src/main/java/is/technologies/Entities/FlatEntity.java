package is.technologies.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "flat", schema = "public", catalog = "forjavalab2")
public class FlatEntity {
    @Id
    @Column(name = "flat_id", nullable = false)
    @Getter
    @Setter
    private Long flatId;

    @Basic
    @Column(name = "flat_number", nullable = false)
    @Getter
    @Setter
    private int flatNumber;

    @Basic
    @Column(name = "flat_square", nullable = false)
    @Getter
    @Setter
    private int flatSquare;

    @Basic
    @Column(name = "number_of_rooms", nullable = false)
    @Getter
    @Setter
    private int NumberOfRooms;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "house", nullable = false)
    @Getter
    @Setter
    private HouseEntity house;
}
