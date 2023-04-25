package generic_utility.javaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * This class has all the generic methods related to java utility
 * @author HP
 *
 */
public class JavaUtility {

	/**
	 * This method is used to get random number from the given range
	 * @author HP
	 */
	public int randomNumber(int boundryValue) {

		return new Random().nextInt(boundryValue);
	}

	/**
	 * This method is used to print the script
	 * @param output
	 */
	public void consolePrint(Object output) {
		System.out.println(output);
	}
/**
 * This method is used to fetch the current date with time 
 * @return
 */
	public String currentDate() {
		Calendar cal=Calendar.getInstance();
		Date currentDate=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy-HH-mm-sss");
		String curDate=sdf.format(currentDate);
		return curDate;
	}
}
