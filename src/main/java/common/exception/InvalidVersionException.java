package common.exception;;

public class InvalidVersionException extends PaymentException{
	//Uncoupled coupling
	//Functional Conhesion: vi ca lop chi co 1 phuong thuc duy nhat huong den 1 nhiem vu duy nhat
	public InvalidVersionException() {
		super("ERROR: Invalid Version Information!");
	}
}
