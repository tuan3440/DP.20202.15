package common.exception;

/**
 * @author
 */
public class FailLoginException extends AimsException {
	//Uncoupled coupling
    public FailLoginException() {
        super("ERROR: Fail to Login. Please try again!");
    }
}
