package common.exception;

/**
 * @author
 */
public class FailLoginException extends AimsException {
	//Uncoupled coupling
	//Functional Conhesion: vi ca lop chi co 1 phuong thuc duy nhat huong den 1 nhiem vu duy nhat
    public FailLoginException() {
        super("ERROR: Fail to Login. Please try again!");
    }
}
