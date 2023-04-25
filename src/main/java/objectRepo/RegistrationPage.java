package objectRepo;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class has all the elements and actions of registration page
 * @author HP
 *
 */
public class RegistrationPage {

	private String registerUserTextFieldPartialXpath = "//input[@name='%s']";
	private WebDriver driver = null;
	@FindBy(name = "username")
	private WebElement userNameTextField;
	@FindBy(name="firstname")
	private WebElement firstNameTextField;
	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	@FindBy(name = "email")
	private WebElement emailTextField;
	@FindBy(name="phone")
	private WebElement phoneNumTextField;
	@FindBy(name="password")
	private WebElement passwordTextField;
	@FindBy(name="cpassword")
	private WebElement confirmpasswordTextField;
	@FindBy(name = "address")
	private WebElement addressTextArea;
	@FindBy(name = "submit")
	private WebElement submitButton;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private WebElement convertToElement(String replaceData) {

		return driver.findElement(By.xpath(String.format(registerUserTextFieldPartialXpath, replaceData)));
	}

	/**
	 * This method is used to register the user in the application
	 * @param username
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phone
	 * @param password
	 * @param cpassword
	 * @param address
	 */
	public void registerUserAction(String username, String firstName,String lastName, String email, String phone, String password, String cpassword,String address) {
		userNameTextField.sendKeys(username);
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		emailTextField.sendKeys(email);
		phoneNumTextField.sendKeys(phone);
		passwordTextField.sendKeys(password);
		confirmpasswordTextField.sendKeys(cpassword);
		addressTextArea.sendKeys(address);
		submitButton.click();
	}
	
	/**
	 * This method is used to create user
	 * @param registrationData
	 * @param username
	 * @param email
	 */
	public void userCreationAction(Map<String, String> registrationData, String username, String email) {

		userNameTextField.sendKeys(username);
		emailTextField.sendKeys(email);
		setDataIntoTextField(registrationData);
		addressTextArea.sendKeys(registrationData.get("address"));
		submitButton.sendKeys();
		
	}
	
/**
 * This method is used to set data in the text field
 * @param registrationData
 */
	private void setDataIntoTextField(Map<String, String> registrationData) {

		for (Map.Entry<String, String> entry : registrationData.entrySet()) {

			if (!(entry.getKey().equals("username") || entry.getKey().equals("email")
					|| entry.getKey().equals("dishquantity") || entry.getKey().equals("address")
					|| entry.getKey().equals("remark") || entry.getKey().equals("")))
				convertToElement(entry.getKey()).sendKeys(entry.getValue());
		}
	}

}
