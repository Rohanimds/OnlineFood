package fc_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPractice {
public static void main(String[] args) {
WebDriverManager.edgedriver().setup();
WebDriver driver=new EdgeDriver();
	driver.get("https:google.com");
	System.out.println("IM TEST1");	
}
}