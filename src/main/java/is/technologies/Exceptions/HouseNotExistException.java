package is.technologies.Exceptions;

public class HouseNotExistException extends Exception {
    public HouseNotExistException() {
        super("House not exist in database");
    }
}
