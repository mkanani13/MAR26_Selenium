package rajashreePatil.CustomeException;

public class BrowserInvalidException extends RuntimeException{

    public BrowserInvalidException(String msg){
        super(msg);
    }
}