package is.technologies.Controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import is.technologies.Entities.HouseEntity;
import is.technologies.Exceptions.HouseNotExistException;
import is.technologies.Exceptions.StreetNotExistException;
import is.technologies.Service.HouseService;
import is.technologies.dto.HouseCreationDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
public class HouseEntityController {
    private final HouseService houseService;

    public HouseEntityController(HouseService houseService){
        this.houseService = houseService;
    }

    @GetMapping(value = "/get/{id}", produces = "application/json")
    @ResponseBody
    HouseEntity getById(@PathVariable("id") Long id) throws HouseNotExistException {
        return houseService.getHouseById(id);
    }


    @PutMapping("/update")
    public String update(@RequestBody HouseCreationDto house) throws StreetNotExistException {
        HouseEntity newHouse = new HouseEntity(house.getHouseId(), house.getHouseName(), house.getDateOfConstruction(), house.getNumberOfFloors(), house.getHouseType(), houseService.getStreetById(house.getStreet()));
        houseService.save(newHouse);
        return "Nice";
    }


    @PostMapping("/create")
    public String create(@RequestBody HouseCreationDto house) throws StreetNotExistException {
        HouseEntity newHouse = new HouseEntity(house.getHouseId(), house.getHouseName(), house.getDateOfConstruction(), house.getNumberOfFloors(), house.getHouseType(), houseService.getStreetById(house.getStreet()));
        houseService.save(newHouse);
        return "Nice";
    }


    @DeleteMapping(path = { "/delete/{id}" })
    public String deleteById(@PathVariable("id") Long id){
        houseService.deleteById(id);
        return "Nice";
    }
}
