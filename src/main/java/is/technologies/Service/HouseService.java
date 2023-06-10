package is.technologies.Service;

import is.technologies.Entities.HouseEntity;
import is.technologies.Entities.StreetEntity;
import is.technologies.Exceptions.HouseNotExistException;
import is.technologies.Exceptions.StreetNotExistException;
import is.technologies.Interfaces.JpaRepositories.HouseRepository;
import is.technologies.Interfaces.JpaRepositories.StreetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseService {

    private final StreetRepository streetRepository;
    private final HouseRepository houseRepository;

    public HouseService(StreetRepository streetRepository, HouseRepository houseRepository){
        this.houseRepository = houseRepository;
        this.streetRepository = streetRepository;
    }

    public StreetEntity getStreetById(long id) throws StreetNotExistException {
        Optional<StreetEntity> street = streetRepository.findById(id);
        if (street.isEmpty()) {
            throw new StreetNotExistException();
        }
        return  street.get();
    }

    public void save(HouseEntity house){
        houseRepository.save(house);
    }

    public void deleteById(long id){
        houseRepository.deleteById(id);
    }

    public void update(HouseEntity house){
        houseRepository.save(house);
    }

    public HouseEntity getHouseById(long id) throws HouseNotExistException {
        Optional<HouseEntity> house = houseRepository.findById(id);
        if (house.isEmpty()) {
            throw new HouseNotExistException();
        }
        return house.get();
    }

}
