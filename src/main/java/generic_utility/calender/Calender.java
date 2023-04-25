package generic_utility.calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * This class has all the generic methods related to calender
 * @author HP
 *
 */
public class Calender {
	private Calendar c;
	private SimpleDateFormat sd;
/**
 * Initialization of Calender
 * @param format
 */
	Calender(String format) {
		c = Calendar.getInstance();
		sd = new SimpleDateFormat(format);
	}
/**
 * This method is used to getDate
 * @return
 * @throws ParseException
 */
	public String getDate() throws ParseException {
		return sd.format(c.getTime());
	}

	/**
	 * This method is used to getDate using String
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public String getDate(String dateString) throws ParseException {
		c.setTime(sd.parse(dateString));
		return sd.format(c.getTime());
	}

	/**
	 * This method is used to add the number of days the date
	 * @param amount
	 * @return
	 * @throws ParseException
	 */
	public String getDate(int amount) throws ParseException {
		c.add(Calendar.DAY_OF_MONTH, amount);
		return sd.format(c.getTime());
	}

	/**
	 * This method is used to get date using String and add the number of days
	 * @param dateString
	 * @param amount
	 * @return
	 * @throws ParseException
	 */
	public String getDate(String dateString, int amount) throws ParseException {
		c.setTime(sd.parse(dateString));
		c.add(Calendar.DAY_OF_MONTH, amount);
		return sd.format(c.getTime());
	}
}