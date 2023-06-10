package is.technologies.Service;

import is.technologies.Entities.FlatEntity;
import is.technologies.Entities.HouseEntity;
import is.technologies.Entities.StreetEntity;
import is.technologies.Exceptions.FlatNotExistException;
import is.technologies.Exceptions.HouseNotExistException;
import is.technologies.Exceptions.StreetNotExistException;
import is.technologies.Interfaces.JpaRepositories.FlatRepository;
import is.technologies.Interfaces.JpaRepositories.HouseRepository;
import is.technologies.Interfaces.JpaRepositories.StreetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlatService {
    private final HouseRepository houseRepository;
    private final FlatRepository flatRepository;

    public FlatService(StreetRepository streetRepository, HouseRepository houseRepository, FlatRepository flatRepository){
        this.houseRepository = houseRepository;
        this.flatRepository = flatRepository;
    }

    public HouseEntity getHouseById(long id) throws HouseNotExistException {
        Optional<HouseEntity> house = houseRepository.findById(id);
        if (house.isEmpty()) {
            throw new HouseNotExistException();
        }
        return house.get();
    }

    public void save(FlatEntity flat){
        flatRepository.save(flat);
    }

    public void deleteById(long id){
        flatRepository.deleteById(id);
    }

    public void update(FlatEntity flat){
        flatRepository.save(flat);
    }

    public FlatEntity getFlatById(long id) throws FlatNotExistException {
        Optional<FlatEntity> flat = flatRepository.findById(id);
        if (flat.isEmpty()) {
            throw new FlatNotExistException();
        }
        return flat.get();
    }
}
