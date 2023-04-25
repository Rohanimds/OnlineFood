package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.javaUtility.wait.WaitUtility;

/**
 * This class has all the elements and actions of admin panel page
 * @author HP
 *
 */
public class AdminPanelPage {

	@FindBy(xpath="//span[text()='Restaurant']")
	private WebElement restaurantModuleExpandButton;
	
	@FindBy(xpath="//a[text()='All Restaurant']")
	private WebElement allRestaurantPageButton;
	
	@FindBy(xpath="//a[text()='Add Category']")
	private WebElement addCategoryPageButton;
	
	@FindBy(xpath="//a[text()='Add Restaurant']")
	private WebElement addRestaurantPageButton;
	
	@FindBy(xpath="//span[text()='Menu']")
	private WebElement menuModuleExpandButton;
	
	@FindBy(xpath="//a[text()='All Menues']")
	private WebElement allMenuesPageButton;
	
	@FindBy(xpath="//a[text()='Add Menu']")
	private WebElement addMenuPageButton;
	
	@FindBy(xpath="//span[text()='Orders']" )
	private WebElement ordersModuleButton;
	
	@FindBy(xpath="//img[@alt='user']")
	private WebElement userLogo;
	
	@FindBy(xpath="//a[text()=' Logout']")
	private WebElement logout;

	public AdminPanelPage(WebDriver driver) { 
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to logout from the admin panel
	 */
	public void logoutAction() {
		userLogo.click();
		logout.click();
	}
	
	/**
	 * This method is used to expand the restaurant module
	 * @param wu
	 */
	public void restaurantModuleExpandButton(WaitUtility wu) {
		try {
			wu.customeWait(500, 10, restaurantModuleExpandButton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to click all restaurants button
	 * @param wu
	 */
	public void allRestaurantPageButton(WaitUtility wu) {
		try {
			wu.customeWait(500, 10, allRestaurantPageButton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to click add category button
	 * @param wu
	 */
	public void addCategoryPageButton(WaitUtility wu) {
		try {
			wu.customeWait(500, 10, addCategoryPageButton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to click add restaurant button
	 * @param wu
	 */
	public void addRestaurantPageButton(WaitUtility wu) {
		try {
			wu.customeWait(500, 10, addRestaurantPageButton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to click menu module expand button
	 * @param wu
	 */
	public void menuModuleExpandButton(WaitUtility wu) {
		try {
			wu.customeWait(500, 10, menuModuleExpandButton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to click all menu page button
	 * @param wu
	 */
	public void allMenuesPageButton(WaitUtility wu) {
		try {
			wu.customeWait(500, 10, allMenuesPageButton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to add menu page button
	 * @param wu
	 */
	public void addMenuPageButton(WaitUtility wu) {
		try {
			wu.customeWait(500, 10, addMenuPageButton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to orders module page button
	 * @param wu
	 */
	public void ordersModuleButton(WaitUtility wu) {
		try {
			wu.customeWait(500, 10, ordersModuleButton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
