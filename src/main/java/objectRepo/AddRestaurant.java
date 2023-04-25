package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.dropdown.Dropdown;

/**
 * This class has all the elements and actions of add restaurant page
 * @author HP
 *
 */
public class AddRestaurant {

	@FindBy(name="res_name")
	private WebElement restaurantNameTextfield;
	
	@FindBy(name="email")
	private WebElement emailTextfield;

	@FindBy(name="phone")
	private WebElement phoneTextField;

	@FindBy(name="url")
	private WebElement websiteUrlTextfield;
	
	@FindBy(name="o_hr")
	private WebElement openHoursDropDown;
	
	@FindBy(name="c_hr")
	private WebElement closeHoursDropDown;
	
	@FindBy(name="o_days")
	private WebElement openDaysDropDown;
	
	@FindBy(name="file")
	private WebElement choseImage;
	
	@FindBy(name="c_name")
	private WebElement categoryName;
	
	@FindBy(name="address")
	private WebElement addressTextArea;
	
	@FindBy(name="submit")
	private WebElement saveButton;
	
	@FindBy(xpath="//div[contains(@class,'alert alert-success')]")
	private WebElement confirmationText;
	
	public AddRestaurant(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to add the restaurant using below parameter
	 * @param resName
	 * @param emailId
	 * @param number
	 * @param website
	 * @param address
	 * @param filePath
	 */
	public void addRestaurant(String resName,String emailId,String number,String website, String address, String filePath) {
	
		restaurantNameTextfield.sendKeys(resName);
		emailTextfield.sendKeys(emailId);
		phoneTextField.sendKeys(number);
		websiteUrlTextfield.sendKeys(website);
		Dropdown dd=new Dropdown();
		dd.selectByValue(openHoursDropDown, "11am");
		dd.selectByVisibleText(closeHoursDropDown, "10pm");
		dd.selectByVisibleText(openDaysDropDown, "Mon-Sat");
		choseImage.sendKeys(filePath);
		dd.selectByVisibleText(categoryName, "Thai770");
		addressTextArea.sendKeys(address);
		saveButton.click();
	}
	
	/**
	 * @return
	 */
	public String getConfirmationText() {
		String text = confirmationText.getText();
		return text;
	}

}