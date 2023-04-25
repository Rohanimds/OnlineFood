package objectRepo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.dropdown.Dropdown;
/**
 * This class has all the elements and actions of add menu page
 * @author HP
 *
 */
public class AddMenuPage {

	@FindBy(name = "d_name")
	private WebElement dishNameTextField;
	@FindBy(name = "about")
	private WebElement descriptionTextField;
	@FindBy(name = "price")
	private WebElement priceTextField;
	@FindBy(id = "lastName")
	private WebElement imageUpload;
	@FindBy(name = "res_name")
	private WebElement selectRestoDropdown;
	@FindBy(name = "submit")
	private WebElement submitButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	private WebElement alertMessage;

	public AddMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to get the text from the alert message
	 * @return
	 */
	public String getAlertMessage() {
		return alertMessage.getText();
	}

	/**
	 * This method is used to add menu using the bellow parameter
	 * @param dropdown
	 * @param restaurantName
	 * @param addDishData
	 * @param imageUrl
	 */
	public void addMenuAction(Dropdown dropdown,String restaurantName, Map<String, String> addDishData, String imageUrl) {

		dishNameTextField.sendKeys(addDishData.get("Dishname"));
		descriptionTextField.sendKeys(addDishData.get("Aboutdish"));
		priceTextField.sendKeys(addDishData.get("price"));
		imageUpload.sendKeys(imageUrl);
		dropdown.selectByVisibleText(selectRestoDropdown,restaurantName);
		submitButton.click();
	}
}
