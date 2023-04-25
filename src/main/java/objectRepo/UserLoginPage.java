package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class has all the elements and actions of user login page
 * @author HP
 *
 */
public class UserLoginPage {

	@FindBy(name = "username")
	private WebElement usernameTextField;
	@FindBy(name = "password")
	private WebElement passwordTextField;
	@FindBy(id = "buttn")
	private WebElement loginButton;

	public UserLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to login the user
	 * @param username
	 * @param password
	 */
	public void loginAction(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
	
}
