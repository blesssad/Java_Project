package is.technologies.Controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import is.technologies.Entities.FlatEntity;
import is.technologies.Exceptions.FlatNotExistException;
import is.technologies.Exceptions.HouseNotExistException;
import is.technologies.Interfaces.JpaRepositories.FlatRepository;
import is.technologies.Service.FlatService;
import is.technologies.SpringConfig;
import is.technologies.dto.FlatCreationDto;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/flat")
public class FlatEntityController {

    private final FlatService flatService;

    public FlatEntityController(FlatService flatService){
        this.flatService = flatService;
    }

    @GetMapping(value = "/get/{id}", produces = "application/json")
    @ResponseBody
    FlatEntity getById(@PathVariable("id") Long id) throws FlatNotExistException {
        return flatService.getFlatById(id);
    }


    @PutMapping("/update")
    public String update(@RequestBody FlatCreationDto flat) throws HouseNotExistException {
        FlatEntity newFlat = new FlatEntity(flat.getFlatId(), flat.getFlatNumber(), flat.getFlatSquare(), flat.getNumberOfRooms(), flatService.getHouseById(flat.getHouse()));
        flatService.save(newFlat);
        return "Nice";
    }


    @PostMapping("/create")
    public String create(@RequestBody FlatCreationDto flat) throws HouseNotExistException {
        FlatEntity newFlat = new FlatEntity(flat.getFlatId(), flat.getFlatNumber(), flat.getFlatSquare(), flat.getNumberOfRooms(), flatService.getHouseById(flat.getHouse()));
        flatService.save(newFlat);
        return "Nice";
    }


    @DeleteMapping(path = { "/delete/{id}" })
    public String deleteById(@PathVariable("id") Long id){
        flatService.deleteById(id);
        return "Nice";
    }
}
