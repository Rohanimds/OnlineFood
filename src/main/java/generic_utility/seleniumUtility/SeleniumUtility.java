package generic_utility.seleniumUtility;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mysql.cj.conf.PropertyKey;

import generic_utility.javaUtility.JavaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class has all the generic methods related to selenium utility
 * @author HP
 *
 */
public class SeleniumUtility {
	private WebDriver driver;
	/**
	 * This method is used to launch the browser
	 * @param browser
	 * @param s
	 * @return
	 */
	public WebDriver launchBrower(String browser,String... s) {
		switch(browser) {
		case "chrome":
			if(s[0].equalsIgnoreCase("option")) {
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--disable-notification");
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(options);
				break;
			}
			else {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			}
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		default:
			System.out.println("Enter proper key");
			break;
		}
		return driver;
	}

	/**
	 * This method is used to maximize the window
	 */
	public void maximizebrowser() {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to go to the website
	 * @param url
	 */
	public void launchapplication(String url) {
		driver.get(url);
	}
	/**
	 * This method is used to resize the window
	 * @param width
	 * @param height
	 */
	public void resizeWindow(int width, int height) {
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));

	}

	/**
	 * This method is used to 
	 */
	public void closeBrowser() {
		driver.quit();
	}
	public void closeTab() {
		driver.close();
	}
	
	public String getCurrenturl() {
		return driver.getCurrentUrl();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getScreenShot(String testCaseName, JavaUtility javaUtility) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("Constants.TEST_SCREENSHOT_PATH"+testCaseName+"_"+javaUtility.currentDate());
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	public String getScreenShot() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}
	
}