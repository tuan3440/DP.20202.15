package common.exception;;

public class InvalidCardException extends PaymentException {
	//Uncoupled coupling
	public InvalidCardException() {
		super("ERROR: Invalid card!");
	}
}
