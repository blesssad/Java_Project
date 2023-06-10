package is.technologies.Controllers;

import is.technologies.Entities.StreetEntity;
import is.technologies.Entities.User;
import is.technologies.Interfaces.JpaRepositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/get/{id}", produces = "application/json")
    @ResponseBody
    Optional<User> getById(@PathVariable("id") Long id){
        return userRepository.findById(id);
    }


    @PutMapping("/update")
    public String update(@RequestBody User user){
        userRepository.save(user);
        return "Nice";
    }


    @PostMapping("/create")
    public String create(@RequestBody User user){
        userRepository.save(user);
        return "Nice";
    }


    @DeleteMapping(path = { "/delete/{id}" })
    public String deleteById(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return "Nice";
    }
}
