package is.technologies.Controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import is.technologies.SpringConfig;
import is.technologies.Entities.StreetEntity;
import is.technologies.Interfaces.JpaRepositories.StreetRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/street")
public class StreetEntityController {

    private final StreetRepository streetRepository;

    public StreetEntityController(StreetRepository streetRepository){
        this.streetRepository = streetRepository;
    }

    @GetMapping(value = "/get/{id}", produces = "application/json")
    @ResponseBody
    Optional<StreetEntity> getById(@PathVariable("id") Long id){
        return streetRepository.findById(id);
    }


    @PutMapping("/update")
    public String update(@RequestBody StreetEntity street){
        streetRepository.save(street);
        return "Nice";
    }


    @PostMapping("/create")
    public String create(@RequestBody StreetEntity street){
        streetRepository.save(street);
        return "Nice";
    }


    @DeleteMapping(path = { "/delete/{id}" })
    public String deleteById(@PathVariable("id") Long id){
        streetRepository.deleteById(id);
        return "Nice";
    }
}
