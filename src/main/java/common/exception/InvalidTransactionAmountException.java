package common.exception;;

public class InvalidTransactionAmountException extends PaymentException {
	//Uncoupled coupling
	public InvalidTransactionAmountException() {
		super("ERROR: Invalid Transaction Amount!");
	}
}
