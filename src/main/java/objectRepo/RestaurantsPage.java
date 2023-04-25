package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class has all the elements and actions of Restaurants page
 * @author HP
 *
 */
public class RestaurantsPage {

	@FindBy(xpath = "//a[text()='View Menu' and @href='dishes.php?res_id=2']")
	private WebElement restaurantNameLink;

	public RestaurantsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to click on the particular restaurant
	 */
	public void clickRestaurantNameLink() {
		restaurantNameLink.click();
	}
	
}
