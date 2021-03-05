package common.exception;;

public class UnrecognizedException extends RuntimeException {
	//Uncoupled coupling
	public UnrecognizedException() {
		super("ERROR: Something went wrowng!");
	}
}
