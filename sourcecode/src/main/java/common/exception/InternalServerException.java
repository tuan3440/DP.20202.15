package common.exception;

public class InternalServerException extends PaymentException {
	//data coupling
	//Functional Conhesion: vi ca lop chi co 1 phuong thuc duy nhat huong den 1 nhiem vu duy nhat
    public InternalServerException(String message) {
        super(message);
    }
}
