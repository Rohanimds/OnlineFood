package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.javaUtility.wait.WaitUtility;

/**
 * This class has all the elements and actions of all orders page
 * @author HP
 *
 */
public class AllOrdersPage {
	@FindBy(xpath="(//tr[last()])[2]//a[contains(@class,'btn btn-info')]")
	private WebElement selectOrder;
	
	public AllOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to select the recent order from the orders table
	 * @param wu
	 */
	public void selectOrderAction(WaitUtility wu) {
		try {
			wu.customeWait(500, 10, selectOrder);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
