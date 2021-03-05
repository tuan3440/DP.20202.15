package common.exception;

public class NotEnoughBalanceException extends PaymentException{
	//Uncoupled coupling
	public NotEnoughBalanceException() {
		super("ERROR: Not enough balance in card!");
	}

}
