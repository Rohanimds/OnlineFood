package generic_utility.Base;

import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import generic_utility.dropdown.Dropdown;
import generic_utility.fetchdata.ExcelOperations;
import generic_utility.fetchdata.FetchDataFromPropertyFile;
import generic_utility.javaUtility.JavaUtility;
import generic_utility.javaUtility.VerificationUtility;
import generic_utility.javaUtility.WebAction.PopupUtility;
import generic_utility.javaUtility.wait.WaitUtility;
import generic_utility.reportutility.ReportUtility;
import generic_utility.seleniumUtility.SeleniumUtility;
import generic_utility.switchto.SwitchToWindow;
import objectRepo.AddCategory;
import objectRepo.AddMenuPage;
import objectRepo.AddRestaurant;
import objectRepo.AdminLoginPage;
import objectRepo.AdminPanelPage;
import objectRepo.AllOrdersPage;
import objectRepo.CheckoutPage;
import objectRepo.DishesPage;
import objectRepo.OrderUpdatePage;
import objectRepo.RegistrationPage;
import objectRepo.RestaurantsPage;
import objectRepo.UserCommonPage;
import objectRepo.UserHomePage;
import objectRepo.UserLoginPage;
import objectRepo.ViewOrderPage;
/**
 * This class has all the declarations from the base class
 * @author HP
 *
 */
public class BaseClassDeclaration {
	protected   String browser;
	protected   String adminUrl;
	protected   String cusUrl;
	protected	String password;
	protected	String username;
	protected	long timeout ;
	protected   WaitUtility wu;
	protected	AdminLoginPage alp;
	protected	AdminPanelPage app;
	protected	AddCategory ac;
	protected	AddRestaurant ar;
	protected	AddMenuPage amp;
	protected	UserCommonPage ucp;
	protected	RegistrationPage rp;
	protected	UserLoginPage ulp;
	protected	RestaurantsPage respage;
	protected	DishesPage dp;
	protected	CheckoutPage cp;
	protected	ViewOrderPage vop;
	protected	AllOrdersPage aop;
	protected	OrderUpdatePage oup;
	protected	int ranintSmall;
	protected	int ranint;
	protected   SwitchToWindow st;
	protected	PopupUtility pu;
	protected	Dropdown dd;
	protected	VerificationUtility vu;
	protected	ExcelOperations eo;
	protected	JavaUtility ju;
	public 	SeleniumUtility su;
	protected	FetchDataFromPropertyFile fdp;
	protected	FileInputStream fis;
	protected	UserHomePage uhp;
	protected   WebDriver driver;
	protected ReportUtility report;
	public ExtentTest test;
	protected SoftAssert sa;
	
	
	
	
}
