package is.technologies.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
@Table(name = "street", schema = "public", catalog = "forjavalab2")
public class StreetEntity implements Serializable {
    @Id
    @Column(name = "street_id", nullable = false)
    @Getter
    @Setter
    private Long streetId;
    @Basic
    @Column(name = "street_name", nullable = false, length = -1)
    @Getter
    @Setter
    private String streetName;
    @Basic
    @Column(name = "postal_code", nullable = false)
    @Getter
    @Setter
    private int postalCode;
}
