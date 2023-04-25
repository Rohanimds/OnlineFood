package fc_practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFileHardcode {
public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/commondata/commondata.properties");

	Properties prop=new Properties();
	
	prop.load(fis);
	
	String password = prop.getProperty("password");
	System.out.println(password);
	fis.close();
}
}