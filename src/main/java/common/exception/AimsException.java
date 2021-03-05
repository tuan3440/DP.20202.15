package common.exception;;

/**
 * The AimsException wraps all unchecked exceptions You can use this
 * exception to inform
 * 
 * @author nguyenlm
 */
public class AimsException extends RuntimeException {

    public AimsException() {

	}
    //data coupling
	public AimsException(String message) {
		super(message);
	}
}