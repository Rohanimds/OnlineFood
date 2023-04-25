package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.dropdown.Dropdown;
import generic_utility.javaUtility.WebAction.PopupUtility;

/**
 * This class has all the elements and actions of Order update page
 * @author HP
 *
 */
public class OrderUpdatePage {

	@FindBy(name = "status")
	private WebElement statusDropdown;

	@FindBy(name = "remark")
	private WebElement remarkTextArea;

	@FindBy(name = "update")
	private WebElement updateButton;

	@FindBy(name = "Submit2")
	private WebElement closeWindowButton;

	
	public OrderUpdatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to update the order using dropdown action
	 * @param dropdown
	 * @param remark
	 */
	public void OrderUpdateAction(Dropdown dropdown, String remark) {
		// Delivered
		dropdown.selectByVisibleText(statusDropdown, remark);
		remarkTextArea.sendKeys(remark);
		

	}
	
	/**
	 * This method is used to add remark
	 * @param remark
	 */
	public void addRemark(String remark) {
		remarkTextArea.sendKeys(remark);
		updateButton.click();
	}
	
	/**
	 * This method is used to close window
	 */
	public void closeWindowAction() {
		closeWindowButton.click();
	}
}
