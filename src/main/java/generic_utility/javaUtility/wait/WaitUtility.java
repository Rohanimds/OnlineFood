package generic_utility.javaUtility.wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class has all the generic methods related to wait.
 * @author HP
 *
 */
public class WaitUtility {
	
	private WebDriverWait wait;
	private WebDriver driver;
	/**
	 * Initialization Wait Utility
	 * @param driver
	 * @param timeout
	 */
	public WaitUtility(WebDriver driver, long timeout){
		this.driver=driver;
		wait = new WebDriverWait(driver,10);

	}
/**
 * This method is used to pause the script for particular timeframe
 * @param milisecond
 */
	public void pause(long milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to wait the script until expected xpath is visible
	 * @param xpath
	 */
	public void waitUntilVisible(String xpath) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
	}

	/**
	 * This method is used to implicitly wait the script for particular timeframe
	 * @param driver
	 * @param timeout
	 */
	public void waitUntilElementToLoad(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to wait the script until expected xpath is clickable
	 * @param xpath
	 */
	public void waitUntilClickable(String xpath) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
	}
	
	public void waitUntilClickable(WebElement we) {
		wait.until(ExpectedConditions.elementToBeClickable(we));
	}
	/**
	 * This method is used to wait the script until present xpath is invisible
	 * @param xpath
	 */
	public void waitUntilInvisible(String xpath) {
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath))));
	}
	
	/**
	 *  This method is used to wait the script until present text invisible
	 * @param xpath
	 * @param text
	 */
	public void waitUntilInvisibleOfText(String xpath, String text) {
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(xpath), text));
	}
	
	/**
	 * This method is used to wait until the title is visible
	 * @param expTitle
	 */
	public void waitUntilTitle(String expTitle) {
		wait.until(ExpectedConditions.titleContains(expTitle));
	}
	
	public void customeWait(long pollingTime, int duration, WebElement ele) throws InterruptedException {
		int count=0;
		while(count<duration) {
			try {
			ele.click();
			break;
			}catch(Exception e) {
				Thread.sleep(pollingTime);
				count=count+((int)pollingTime/1000);
			}
		}
	}
}
