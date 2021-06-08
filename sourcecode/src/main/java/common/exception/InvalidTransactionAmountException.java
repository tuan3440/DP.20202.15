package common.exception;;

public class InvalidTransactionAmountException extends PaymentException {
	//Uncoupled coupling
	//Functional Conhesion: vi ca lop chi co 1 phuong thuc duy nhat huong den 1 nhiem vu duy nhat
	public InvalidTransactionAmountException() {
		super("ERROR: Invalid Transaction Amount!");
	}
}
