package smratiGarg.PageFactory.customeException;

public class BrowserInvalidException extends RuntimeException{

    public BrowserInvalidException(String msg) {
        super(msg);
    }
}
