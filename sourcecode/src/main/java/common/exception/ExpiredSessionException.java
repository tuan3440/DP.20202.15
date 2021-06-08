package common.exception;

/**
 * @author
 */
public class ExpiredSessionException extends AimsException {
	 //uncoupled coupling
	//Functional Conhesion: vi ca lop chi co 1 phuong thuc duy nhat huong den 1 nhiem vu duy nhat
    public ExpiredSessionException() {
        super("ERROR: Your session has expired. Please login again!");
    }
}
