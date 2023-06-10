package is.technologies.Interfaces.JpaRepositories;

import is.technologies.Entities.HouseEntity;
import is.technologies.Entities.StreetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<StreetEntity, Long> {
    List<StreetEntity> getStreetEntitiesByStreetName(String name);
}
