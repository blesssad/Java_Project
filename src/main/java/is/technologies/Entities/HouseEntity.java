package is.technologies.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "house", schema = "public", catalog = "forjavalab2")
public class HouseEntity {
    @Id
    @Column(name = "house_id", nullable = false)
    @Getter
    @Setter
    private Long houseId;
    @Basic
    @Column(name = "house_name", nullable = false, length = -1)
    @Getter
    @Setter
    private String houseName;
    @Basic
    @Column(name = "date_of_construction", nullable = false)
    @Getter
    @Setter
    private Date dateOfConstruction;
    @Basic
    @Column(name = "number_of_floors", nullable = false)
    @Getter
    @Setter
    private int numberOfFloors;
    @Basic
    @Column(name = "house_type", nullable = false, length = -1)
    @Getter
    @Setter
    private String houseType;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "street", nullable = false)
    @Getter
    @Setter
    private StreetEntity street;
}
