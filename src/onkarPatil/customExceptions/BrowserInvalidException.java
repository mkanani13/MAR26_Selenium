package onkarPatil.customExceptions;

public class BrowserInvalidException extends RuntimeException{
    public BrowserInvalidException(String message){
        super(message);
    }
}
