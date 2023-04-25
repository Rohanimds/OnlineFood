package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class has all the elements and actions of user common page
 * @author HP
 *
 */
public class UserCommonPage {

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerLink;
	@FindBy(xpath = "//a[text()='Restaurants ']")
	private WebElement restaurantsLink;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement login;

	public UserCommonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to click on the register link
	 */
	public void clickRegisterLink() {
		registerLink.click();
	}
	
	/**
	 * This method is used to  click on the restaurants link
	 */
	public void clickRestaurantsLink() {
		restaurantsLink.click();
	}
	
	/**
	 * This method is used to click on logout button
	 */
	public void customerLogout() {
		logout.click();
	}
	
	/**
	 * This method is used to click on login button
	 */
	public void login() {
		login.click();
	}
}
