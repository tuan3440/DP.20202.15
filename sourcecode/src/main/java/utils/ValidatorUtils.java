package utils;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils {  //Tao lop rieng de xu li validate

	public static final int LENGTH_MAX_PHONENUMBER = 10;  // Replace a magic number with a named constant
	public static final String PATTERN_STRING = "^[a-zA-Z\\s]*$";
	
	 private static ValidatorUtils singleton;

	 private ValidatorUtils () {};
	 public synchronized static ValidatorUtils getInstance() {
	        if(singleton == null) singleton = new ValidatorUtils();
	        return singleton;
	    }
	 public boolean validatePhoneNumber(String phoneNumber) {
	    	//Data-Level Refactoring/Introduce an intermediate variable
	        if (phoneNumber.length() != LENGTH_MAX_PHONENUMBER) return false;
	        if (!phoneNumber.startsWith("0")) return false;
	        try {
	            Integer.parseInt(phoneNumber);
	        } catch (NumberFormatException e) {
	            return false;
	        }
	        return true;
	    }
	    //Functional Conhesion
	    //Data coupling
	 public boolean validateString(String name) {
	        if (Objects.isNull(name)) return false;
	        Pattern pattern = Pattern.compile(PATTERN_STRING);
	        Matcher matcher = pattern.matcher(name);
	        return matcher.matches();
	}
}
