package common.exception;;

public class InternalServerErrorException extends PaymentException {
	//Uncoupled coupling
	//Functional Conhesion: vi ca lop chi co 1 phuong thuc duy nhat huong den 1 nhiem vu duy nhat
	public InternalServerErrorException() {
		super("ERROR: Internal Server Error!");
	}

}
