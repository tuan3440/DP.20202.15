package common.exception;;

public class PaymentException extends RuntimeException {
	//Data coupling
	public PaymentException(String message) {
		super(message);
	}
}
