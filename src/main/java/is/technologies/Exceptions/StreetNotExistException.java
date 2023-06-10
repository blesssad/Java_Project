package is.technologies.Exceptions;

public class StreetNotExistException extends Exception{
        public StreetNotExistException()
        {
            super("Street not exist in database");
        }
}
