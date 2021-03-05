package common.exception;;

public class SuspiciousTransactionException extends PaymentException {
	//Uncoupled coupling
	public SuspiciousTransactionException() {
		super("ERROR: Suspicious Transaction Report!");
	}
}
