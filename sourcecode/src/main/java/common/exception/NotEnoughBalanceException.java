package common.exception;

public class NotEnoughBalanceException extends PaymentException{
	//Uncoupled coupling
	//Functional Conhesion: vi ca lop chi co 1 phuong thuc duy nhat huong den 1 nhiem vu duy nhat
	public NotEnoughBalanceException() {
		super("ERROR: Not enough balance in card!");
	}

}
