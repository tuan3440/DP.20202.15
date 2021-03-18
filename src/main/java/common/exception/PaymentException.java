package common.exception;;

public class PaymentException extends RuntimeException {
	//Data coupling
	//Functional Conhesion: vi ca lop chi co 1 phuong thuc duy nhat huong den 1 nhiem vu duy nhat
	public PaymentException(String message) {
		super(message);
	}
}
