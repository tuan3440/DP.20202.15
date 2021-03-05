package common.exception;

/**
 * @author
 */
public class ExpiredSessionException extends AimsException {
	 //uncoupled coupling
    public ExpiredSessionException() {
        super("ERROR: Your session has expired. Please login again!");
    }
}
