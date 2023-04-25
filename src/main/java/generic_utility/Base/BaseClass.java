package generic_utility.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import generic_utility.constants.Constants;
import generic_utility.dropdown.Dropdown;
import generic_utility.enums.PropertyKey;
import generic_utility.fetchdata.ExcelOperations;
import generic_utility.fetchdata.FetchDataFromPropertyFile;
import generic_utility.javaUtility.JavaUtility;
import generic_utility.javaUtility.VerificationUtility;
import generic_utility.javaUtility.WebAction.PopupUtility;
import generic_utility.javaUtility.wait.WaitUtility;
import generic_utility.listener.ExtentReportsListener;
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
 * This class has all the generic operation that are common in all the testcases
 * @author HP
 *
 */
public class BaseClass extends BaseClassDeclaration {

	@BeforeClass(alwaysRun = true)
	public void intsalationSetup() {
		report=ExtentReportsListener.sreport;
		
		try {
			fis = new FileInputStream(Constants.TEST_PROPERTY_FILE_PATH);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			fdp = new FetchDataFromPropertyFile(Constants.TEST_PROPERTY_FILE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		su = new SeleniumUtility();
		ju = new JavaUtility();
		eo = new ExcelOperations(Constants.TEST_EXCEL_FILE_PATH);
		vu = new VerificationUtility();
		dd = new Dropdown();
		pu = new PopupUtility();
		st = new SwitchToWindow();

		browser = fdp.getPropertyStringData(PropertyKey.BROWSER);
		adminUrl = fdp.getPropertyStringData(PropertyKey.ADMINURL);
		cusUrl = fdp.getPropertyStringData(PropertyKey.CUSTOMERURL);
		password = fdp.getPropertyStringData(PropertyKey.PASSWORD);
		username = fdp.getPropertyStringData(PropertyKey.USERNAME);
		long timeout = fdp.getPropertyLongData(PropertyKey.TIMEOUT);
	}

	@Parameters(value ="browser")
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional String browser) {
		this.browser=browser;
		//if(browser==null||browser.isEmpty()||browser.isBlank()||browser.equals(""))
			if(browser==null)
		{
			browser=fdp.getPropertyStringData(PropertyKey.BROWSER);
		}
		driver = su.launchBrower(browser, "option");
		su.maximizebrowser();
		wu = new WaitUtility(driver, timeout);
		alp = new AdminLoginPage(driver);
		app = new AdminPanelPage(driver);
		ac = new AddCategory(driver);
		ar = new AddRestaurant(driver);
		amp = new AddMenuPage(driver);
		ucp = new UserCommonPage(driver);
		rp = new RegistrationPage(driver);
		ulp = new UserLoginPage(driver);
		respage = new RestaurantsPage(driver);
		dp = new DishesPage(driver);
		cp = new CheckoutPage(driver);
		vop = new ViewOrderPage(driver);
		aop = new AllOrdersPage(driver);
		oup = new OrderUpdatePage(driver);
		uhp=new UserHomePage(driver);
		wu.waitUntilElementToLoad(driver, timeout);

		ranint = ju.randomNumber(1000);
		ranintSmall = ju.randomNumber(99);
	}

	@AfterMethod(alwaysRun = true)
	public void logout() {
		su.closeBrowser();

	}

	@AfterClass(alwaysRun = true)
	public void close() {
		try {
			eo.closeWorkBook();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
