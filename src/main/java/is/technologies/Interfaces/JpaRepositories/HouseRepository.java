package is.technologies.Interfaces.JpaRepositories;

import is.technologies.Entities.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<HouseEntity, Long> {
    List<HouseEntity> getHouseEntitiesByStreet_StreetId(long streetId);

    List<HouseEntity> getHouseEntitiesByHouseName(String name);
}
