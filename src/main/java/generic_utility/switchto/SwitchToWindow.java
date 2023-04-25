package generic_utility.switchto;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;


/**
 * This class has all the generic methods related to switchto
 * @author HP
 *
 */
public class SwitchToWindow {
	/**
	 * This method is used to switch between windows
	 * @author HP
	 *
	 */
	public void switchToWindow(WebDriver driver, String PartialWindowTitle) {
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while (it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			if (driver.getTitle().contains(PartialWindowTitle)) {
				break;
			}
		}
	}
	
	/**
	 * This method is used to direct switch to particular page
	 * @param driver
	 * @param pageName
	 */
	public void directSwitchTo(WebDriver driver, String pageName) {
		driver.switchTo().window(pageName);
	}
}
