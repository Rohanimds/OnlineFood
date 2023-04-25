package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class has all the elements and actions of CheckoutPage page
 * @author HP
 *
 */
public class CheckoutPage {

	@FindBy(name = "submit")
	private WebElement orderNowButton;

	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to click on orders now button
	 */
	public void orderNowAction() {
		orderNowButton.click();
	}
}
