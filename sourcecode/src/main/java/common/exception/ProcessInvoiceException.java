package common.exception;;

/**
 * The ProcessInvoiceException wraps all unchecked exceptions You can use this
 * exception to inform 
 * 
 * @author nguyenlm
 */
public class ProcessInvoiceException extends AimsException {

	private static final long serialVersionUID = 1091337136123906298L;

	public ProcessInvoiceException() {

	}
	//Data coupling
	//Functional Conhesion: vi ca lop chi co 1 phuong thuc duy nhat huong den 1 nhiem vu duy nhat
	public ProcessInvoiceException(String message) {
		super(message);
	}

}
