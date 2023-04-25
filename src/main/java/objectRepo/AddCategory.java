package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.javaUtility.wait.WaitUtility;

/**
 * This class has all the elements and actions of AddCategory page
 * @author HP
 *
 */
public class AddCategory {

	@FindBy(name="c_name")
	private WebElement addCategoryTextfield;
	
	@FindBy(name="submit")
	private WebElement saveButton;
	
	@FindBy(xpath="//div[contains(@class,'alert alert-success')]")
	private WebElement confirmationText;
	
	public AddCategory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to send the category name in the textfield
	 * @param categoryName
	 * @param wu
	 */
	public void addCategoryTextfield(String categoryName, WaitUtility wu) {
		addCategoryTextfield.sendKeys(categoryName);
		try {
			wu.customeWait(500, 10, saveButton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to get the text from the confirmation message
	 * @return
	 */
	public String getConfirmationText() {
		String text = confirmationText.getText();
		return text;
	}
}
