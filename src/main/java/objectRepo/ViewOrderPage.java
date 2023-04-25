package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class has all the elements and actions of view order page
 * @author HP
 *
 */
public class ViewOrderPage {

	@FindBy(xpath = "//button[text()='Update Order Status']")
	private WebElement updateOrderStatusButton;

	public ViewOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to  is used to click on the update irder status button
	 */
	public void clickUpdateOrderStatusButton() {
		updateOrderStatusButton.click();
	}

}
