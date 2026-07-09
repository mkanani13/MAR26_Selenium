package vishwajeetLoni.customExceptions;

public class BrowserNotSupportedException extends RuntimeException{

    public BrowserNotSupportedException (String msg){
        super(msg);
    }
}
