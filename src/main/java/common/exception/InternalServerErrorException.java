package common.exception;;

public class InternalServerErrorException extends PaymentException {
	//Uncoupled coupling
	public InternalServerErrorException() {
		super("ERROR: Internal Server Error!");
	}

}
