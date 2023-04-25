package updatedtstngofos;

import java.io.FileInputStream;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.Base.BaseClass;
import generic_utility.annotation.Record;
import generic_utility.constants.Constants;
import generic_utility.dropdown.Dropdown;
import generic_utility.enums.PropertyKey;
import generic_utility.fetchdata.ExcelOperations;
import generic_utility.fetchdata.FetchDataFromPropertyFile;
import generic_utility.javaUtility.JavaUtility;
import generic_utility.javaUtility.VerificationUtility;
import generic_utility.javaUtility.WebAction.PopupUtility;
import generic_utility.javaUtility.wait.WaitUtility;
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
import objectRepo.UserLoginPage;
import objectRepo.ViewOrderPage;

public class EndToEnd extends BaseClass{

	@Record(author = "Rohan")
	@Test(groups= {"regression","sanity","major"})
	public void endToEnd() throws Throwable {

		su.launchapplication(adminUrl);

		String expTitle = eo.getExcelData("adminpagetitlename", "loginpagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		String actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Login Page is fail");

		alp.loginAction(username, password);

		expTitle = eo.getExcelData("adminpagetitlename", "adminpanelpage", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Home Page is fail");

		app.restaurantModuleExpandButton(wu);
		app.addCategoryPageButton(wu);

		expTitle = eo.getExcelData("adminpagetitlename", "addcategorypage", "Titleslist");
		wu.waitUntilTitle(expTitle);

		String resSelectCategory = eo.getExcelData("AddRestaurant", "Select Category", "TestScript");
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Category Page is fail");
		String category = resSelectCategory + ranint;

		ac.addCategoryTextfield(category, wu);

		String gt = ac.getConfirmationText();

		String expConfirmation = eo.getExcelData("Confirmationtitles", "categoryadded", "Titleslist");
		wu.waitUntilVisible("//div[contains(@class,'alert alert-success')]");
		String actConfirmation = gt;
		Assert.assertTrue(actConfirmation.contains(expConfirmation),"Category element is fail");

		app.addRestaurantPageButton(wu);

		expTitle = eo.getExcelData("adminpagetitlename", "addrestaurantpage", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Category Page is fail");

		Map<String, String> data = eo.getExcelData("AddRestaurant", "TestScript");
		String resName=data.get("Restaurant Name");
		String resEmail=data.get("Bussiness E-mail");
		String resPhone=data.get("Phone");
		String resWebsite=data.get("Website URL");
		String resOpenHour=data.get("Open Hours");
		String resCloseHour=data.get("Close Hours");
		String resOpenDays=data.get("Open Days");
		String resAddress=data.get("Restaurant Address");

		resName=resName + ranint;
		resEmail=resEmail + ranint + "@gmail.com";
		resPhone=resPhone + ranintSmall;
		resWebsite=resWebsite + ranint + ".com";
		String filePath = "F:\\Restaurant photo\\images (3).jpg";

		ar.addRestaurant(resName, resEmail, resPhone, resWebsite, resAddress, filePath);
		gt=ar.getConfirmationText();

		expConfirmation = eo.getExcelData("Confirmationtitles", "restaurantadded", "Titleslist");
		wu.waitUntilVisible("//div[contains(@class,'alert alert-success')]");
		actConfirmation = gt;
		Assert.assertTrue(actConfirmation.contains(expConfirmation),"Restaurant element is fail");

		app.menuModuleExpandButton(wu);
		app.addMenuPageButton(wu);

		expTitle = eo.getExcelData("adminpagetitlename", "addmenupage", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Menu Page is fail");

		String dishName=data.get("Dishname");
		String aboutDish=data.get("Aboutdish");
		String dishPrice=data.get("price");

		dishName=dishName+ranint;

		amp.addMenuAction(dd, resName, data,"F:\\Restaurant photo\\pasta carbonara.jpg");
		gt=amp.getAlertMessage();

		expConfirmation = eo.getExcelData("Confirmationtitles", "dishadded", "Titleslist");
		wu.waitUntilVisible("//div[contains(@class,'alert alert-success')]");
		actConfirmation = gt;
		Assert.assertTrue(actConfirmation.contains(expConfirmation),"Dish element is fail");

		app.logoutAction();

		su.launchapplication(cusUrl);

		expTitle = eo.getExcelData("Pagetitlename", "homepagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Home Page is fail");

		ucp.clickRegisterLink();

		expTitle = eo.getExcelData("Pagetitlename", "registrationpagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Registration Page is fail");

		data = eo.getExcelData("CustomerPlacesOrder", "TestScript");
		String cusName=data.get("Name")+ranint;
		String cusFirstName=data.get("FirstName")+ranint;
		String cusLastName=data.get("LastName");
		String cusEmailId=data.get("E-mail")+ranint+"@gmail.com";
		String cusPhoneNum=data.get("Phone")+ranintSmall;
		String cusPassword=data.get("Password");
		String cusCpassword=data.get("Cpassword");
		String cusAddress=data.get("Address");

		rp.registerUserAction(cusName,cusFirstName, cusLastName, cusEmailId, cusPhoneNum, cusPassword, cusCpassword, cusAddress);

		expTitle = eo.getExcelData("Pagetitlename", "loginpagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Login Page is fail");

		ulp.loginAction(cusName, cusPassword);

		expTitle = eo.getExcelData("Pagetitlename", "homepagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Home Page is fail");

		ucp.clickRestaurantsLink();

		expTitle = eo.getExcelData("Pagetitlename", "restaurantspagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Restaurants Page is fail");

		respage.clickRestaurantNameLink();

		expTitle = eo.getExcelData("Pagetitlename", "dishespagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Dishes Page is fail");

		String orderdish = "Pink Spaghetti Gamberoni";
		dp.addToCartAction(orderdish);
		dp.checkoutAction();

		expTitle = eo.getExcelData("Pagetitlename", "checkoutpagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();

		cp.orderNowAction();

		pu.acceptAlert(driver);
		pu.acceptAlert(driver);

		expTitle = eo.getExcelData("Pagetitlename", "orderspagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"My Orders Page is fail");

		su.launchapplication(adminUrl);

		expTitle = eo.getExcelData("adminpagetitlename", "loginpagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Login Page is fail");

		alp.loginAction(username, password);

		expTitle = eo.getExcelData("adminpagetitlename", "adminpanelpage", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Admin Page is fail");

		app.ordersModuleButton(wu);
		expTitle = eo.getExcelData("adminpagetitlename", "allorderspage", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"All orders Page is fail");

		aop.selectOrderAction(wu);

		expTitle = eo.getExcelData("adminpagetitlename", "vieworderspage", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"ViewOrders Page is fail");

		vop.clickUpdateOrderStatusButton();

		String etitle = "Order Update";
		String parent = driver.getWindowHandle();

		st.switchToWindow(driver, etitle);

		expTitle = eo.getExcelData("adminpagetitlename", "orderupdatepage", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"OrderUpdate Page is fail");

		String delivered = eo.getExcelData("AddRestaurant", "dishdelivered", "TestScript");

		WebElement ele = driver.findElement(By.name("status"));
		dd.selectByVisibleText(ele, delivered);

		oup.addRemark(delivered);

		pu.acceptAlert(driver);

		oup.closeWindowAction();

		st.directSwitchTo(driver, parent);

		expTitle = eo.getExcelData("adminpagetitlename", "vieworderspage", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"ViewOrders Page is fail");

		app.logoutAction();
	}
}

