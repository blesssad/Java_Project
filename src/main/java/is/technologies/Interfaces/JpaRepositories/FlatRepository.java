package is.technologies.Interfaces.JpaRepositories;

import is.technologies.Entities.FlatEntity;
import is.technologies.Entities.HouseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlatRepository extends JpaRepository<FlatEntity, Long> {
    List<FlatEntity> getFlatEntitiesByHouse_HouseId(long houseId);
}
