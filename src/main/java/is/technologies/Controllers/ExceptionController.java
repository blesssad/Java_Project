package is.technologies.Controllers;

import is.technologies.Exceptions.HouseNotExistException;
import is.technologies.Exceptions.StreetNotExistException;
import is.technologies.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = StreetNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionDto handleException(StreetNotExistException e){
        return new ExceptionDto(e);
    }

    @ExceptionHandler(value = HouseNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionDto handleException(HouseNotExistException e){
        return new ExceptionDto(e);
    }
}
