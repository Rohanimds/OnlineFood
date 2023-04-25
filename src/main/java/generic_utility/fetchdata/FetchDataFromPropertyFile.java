package generic_utility.fetchdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.mysql.cj.conf.PropertyKey;

/**
 * This class has all the generic methods related to fetching data from the property file
 * @author HP
 *
 */
public class FetchDataFromPropertyFile {

	private Properties prop;
/**
 * This method is used to initialize property file
 * @param filePath
 * @throws IOException
 */
	public  FetchDataFromPropertyFile(String filePath) throws IOException {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
/**
 * This methos is used fetch the data from the property file
 * @param browser
 * @return
 */
	public String getPropertyStringData(generic_utility.enums.PropertyKey input) {
	String pk = input.name().toLowerCase();
	
		return prop.getProperty(pk, "").trim();
	}
	
	public long getPropertyLongData(generic_utility.enums.PropertyKey input) {
		String pk = input.name().toLowerCase();
		
		return Long.parseLong(prop.getProperty(pk, "").trim());
	}
	
	/**
	 * this methos is used to clear the ram data of property file
	 */
	public void clear() {
		prop.clear();
	}

}