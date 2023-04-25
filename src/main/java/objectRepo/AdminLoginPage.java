package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class has all the elements and actions of admin login page
 * @author HP
 *
 */
public class AdminLoginPage {

	@FindBy(name="username")
	private WebElement userNameTextField;

	@FindBy(name="password")
	private WebElement passwordTextField;
	
	@FindBy(name="submit")
	private WebElement loginButton;
	
	public AdminLoginPage(WebDriver driver) { 
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to login to the admin panel
	 * @param userName
	 * @param password
	 */
	public void loginAction(String userName, String password) {
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		loginButton.click();
	
}
}
