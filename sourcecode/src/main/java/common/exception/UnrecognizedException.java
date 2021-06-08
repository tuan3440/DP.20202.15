package common.exception;;

public class UnrecognizedException extends RuntimeException {
	//Uncoupled coupling
	//Functional Conhesion: vi ca lop chi co 1 phuong thuc duy nhat huong den 1 nhiem vu duy nhat
	public UnrecognizedException() {
		super("ERROR: Something went wrowng!");
	}
}
