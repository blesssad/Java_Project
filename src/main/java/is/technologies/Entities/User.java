package is.technologies.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users", schema = "public", catalog = "forjavalab2")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @Getter
    @Setter
    private Long userId;

    @Basic
    @Column(name = "user_name", nullable = false, length = -1)
    @Getter
    @Setter
    private String name;

    @Basic
    @Column(name = "password", nullable = false, length = -1)
    @Getter
    @Setter
    private String password;

    @Basic
    @Column(name = "role", nullable = false)
    @Getter
    @Setter
    private Role role;
}
