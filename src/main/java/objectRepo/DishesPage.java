package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class has all the elements and actions of Dishes page
 * @author HP
 *
 */
public class DishesPage {

	private String quantityTextFieldPartialXpath = "//div[@class='food-item']//a[text()='%s']//ancestor::div[@class='col-xs-12 col-sm-12 col-lg-8']/following-sibling::div//input[@name='quantity']";
	private String addToCartButtonPartialXpath = "//div[@class='food-item']//a[text()='%s']//ancestor::div[@class='col-xs-12 col-sm-12 col-lg-8']/following-sibling::div//*[@value='Add To Cart']";
	private WebDriver driver = null;
	@FindBy(name = "quantity")
	private WebElement quantityTextField;
	@FindBy(xpath = "//*[@value='Add To Cart']")
	private WebElement addToCartButton;
	@FindBy(xpath = "//*[text()='Checkout']")
	private WebElement checkoutButton;

	public DishesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private WebElement convertToElement(String partialXpath, String replaceData) {
		return driver.findElement(By.xpath(String.format(partialXpath, replaceData)));
	}

	/**
	 * This method is used to add the dish quantity and click on add to cart button
	 * @param qty
	 */
//	public void addToCartAction(String qty) {
//		quantityTextField.clear();
//		quantityTextField.sendKeys(qty);
//		addToCartButton.click();
//	}

	/**
	 * This method is used to select the dish, add the dish quantity and click on cart button
	 * @param dish
	 * @param qty
	 */
	public void addToCartAction(String dish) {
		WebElement quantity = convertToElement(quantityTextFieldPartialXpath, dish);
		quantity.clear();
		quantity.sendKeys("1");
		convertToElement(addToCartButtonPartialXpath, dish).click();
	}

	/**
	 * This method is used to click on checkout button
	 */
	public void checkoutAction() {
		checkoutButton.click();
	}
}
