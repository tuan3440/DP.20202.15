package common.exception;

/**
 * The PlaceOrderException wraps all unchecked exceptions You can use this
 * exception to inform 
 * 
 * @author nguyenlm
 */
public class PlaceOrderException extends AimsException {

	private static final long serialVersionUID = 1091337136123906298L;

	public PlaceOrderException() {

	}
	//Data coupling
	//Functional Conhesion: vi ca lop chi co 1 phuong thuc duy nhat huong den 1 nhiem vu duy nhat
	public PlaceOrderException(String message) {
		super(message);
	}

}
