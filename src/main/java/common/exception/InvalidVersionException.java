package common.exception;;

public class InvalidVersionException extends PaymentException{
	//Uncoupled coupling
	public InvalidVersionException() {
		super("ERROR: Invalid Version Information!");
	}
}
