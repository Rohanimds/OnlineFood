package generic_utility.javaUtility.WebAction;

import java.util.Set;

import org.openqa.selenium.WebDriver;
/**
 * This class has all the generic methods related to popup
 * @author HP
 *
 */
public class PopupUtility {
	/**
	 * This method is used the accept the popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to dismiss the popup
	 * @param driver
	 */
	public void closeAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to set data to the popup
	 * @param driver
	 * @param data
	 */
	public void setDataToAlert(WebDriver driver, String data) {
		driver.switchTo().alert().sendKeys(data);
	}
	/**
	 * This popup is used to get text from the popup
	 * @param driver
	 */
	public void getPopUpText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	/**
	 * This method is used to switch the window by url or title.
	 * @param driver
	 * @param strategy
	 * @param verificationValue
	 */
	public void switchWindow(WebDriver driver, String strategy, String verificationValue) {
		Set<String> windows = driver.getWindowHandles();
		for(String id:windows) {
			driver.switchTo().window(id);
			if(strategy.equalsIgnoreCase("exact_url")) {
				if(driver.getCurrentUrl().equalsIgnoreCase(verificationValue)) {
					break;			
				}
			}
			else if(strategy.equalsIgnoreCase("partial_url")) {
				if(driver.getCurrentUrl().equalsIgnoreCase(verificationValue)) {
					break;			
				}
			}
			else if(strategy.equalsIgnoreCase("exact_title")) {
				if(driver.getCurrentUrl().equalsIgnoreCase(verificationValue)) {
					break;			
				}
			}
			else if(strategy.equalsIgnoreCase("partial_title")) {
				if(driver.getCurrentUrl().equalsIgnoreCase(verificationValue)) {
					break;			
				}
			}
		}
	}
}
