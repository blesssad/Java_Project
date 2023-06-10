package is.technologies.Exceptions;

public class FlatNotExistException extends Exception{
    public FlatNotExistException() {
        super("Flat not exist in database");
    }
}
