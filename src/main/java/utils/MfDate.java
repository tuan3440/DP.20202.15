package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MfDate {
	/**
     * Return a {@link String String} that represents the current time in the format of yyyy-MM-dd HH:mm:ss.
     *
     * @author hieudm
     * @return the current time as {@link String String}.
     */
	 public static String getToday() {     //Coincidental Cohesion vi phuong thuc nay khong lien quan den cac phuong thuc con lai cua class

		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 return dateFormat.format(date);
	 }
}
