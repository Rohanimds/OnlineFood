package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class has all the elements and actions of user home page
 * @author HP
 *
 */
public class UserHomePage {
	
	WebDriver driver;
	@FindBy(xpath = "//a[contains(@href,'id=4') and text()='Order Now']")
	private WebElement orderNowLink;
	
	private String partialDishName="//a[text()='%s']";
	
	/**
	 * This method is used to convert from partial xpath to webelement
	 * @param dishName
	 * @return
	 */
	private WebElement convertToWebElement(String dishName) {
		String Xpath=String.format(partialDishName, dishName);
		return driver.findElement(By.xpath(Xpath));	
	}
	
	public UserHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	/**
	 * This method is used to click on the order now button
	 */
	public void clickOrderNowLink() {
		orderNowLink.click();
	}
	
	/**
	 * This method is used to click on the dish from home page
	 * @param dishName
	 */
	public void clickDishFromHomePage(String dishName) {
		convertToWebElement(dishName).click();
	}
}
