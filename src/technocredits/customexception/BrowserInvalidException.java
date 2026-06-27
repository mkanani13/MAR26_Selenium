package technocredits.customexception;

public class BrowserInvalidException extends RuntimeException{
	
	public BrowserInvalidException(String msg) {
        super(msg);
	}
}
