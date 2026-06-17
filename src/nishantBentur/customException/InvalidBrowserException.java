package nishantBentur.customException;

public class InvalidBrowserException extends RuntimeException{

    public InvalidBrowserException(String msg) {
        super(msg);
    }
}
