package is.technologies.dto;

public class ExceptionDto {
    private final Exception exception;

    public ExceptionDto(Exception exception){
        this.exception = exception;
    };

    public String getExceptionMessage(){
        return exception.getMessage();
    }
}
