package common.exception;;

/**
 * The AimsException wraps all unchecked exceptions You can use this
 * exception to inform
 * 
 * @author nguyenlm
 */
public class AimsException extends RuntimeException {

    public AimsException() {

	}
    //data coupling
    //Functional Conhesion: vi ca lop chi co 1 phuong thuc duy nhat huong den 1 nhiem vu duy nhat
	public AimsException(String message) {
		super(message);
	}
}