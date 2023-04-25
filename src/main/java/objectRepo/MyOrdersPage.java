package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class has all the elements and actions of My orders page
 * @author HP
 *
 */
public class MyOrdersPage {
	
	@FindBy(xpath = "(//td[@data-column='Date'])[last()]")
	private WebElement orderTime;

	public MyOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to get order time
	 * @return
	 */
	public String getOrderTime() {
		return orderTime.getText().trim();
	}
}
