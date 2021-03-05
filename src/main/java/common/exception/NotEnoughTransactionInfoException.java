package common.exception;

public class NotEnoughTransactionInfoException extends PaymentException {
	//Uncoupled coupling
	public NotEnoughTransactionInfoException() {
	super("ERROR: Not Enough Transcation Information");
}
}
