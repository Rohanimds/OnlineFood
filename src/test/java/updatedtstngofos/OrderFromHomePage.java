package updatedtstngofos;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.Base.BaseClass;
import generic_utility.annotation.Record;
import generic_utility.constants.Constants;
import generic_utility.enums.PropertyKey;
import generic_utility.fetchdata.ExcelOperations;
import generic_utility.fetchdata.FetchDataFromPropertyFile;
import generic_utility.javaUtility.JavaUtility;
import generic_utility.javaUtility.VerificationUtility;
import generic_utility.javaUtility.WebAction.PopupUtility;
import generic_utility.javaUtility.wait.WaitUtility;
import generic_utility.seleniumUtility.SeleniumUtility;
import objectRepo.CheckoutPage;
import objectRepo.DishesPage;
import objectRepo.RegistrationPage;
import objectRepo.RestaurantsPage;
import objectRepo.UserCommonPage;
import objectRepo.UserHomePage;
import objectRepo.UserLoginPage;

public class OrderFromHomePage extends BaseClass{

	@Record(author = "Rohan")
	@Test(groups= {"regression"})
	public void orderFromHomePage() {
		su.launchapplication(cusUrl);

		String expTitle = eo.getExcelData("Pagetitlename", "homepagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		String actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Home Page is fail");


		String selectDish = eo.getExcelData("Order_From_HomePage2", "Selectdish", "TestScript");

		uhp.clickDishFromHomePage(selectDish);

		dp.addToCartAction(selectDish);
		dp.checkoutAction();

		ucp.clickRegisterLink();

		expTitle = eo.getExcelData("Pagetitlename", "registrationpagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Registration Page is fail");

		Map<String, String> data = eo.getExcelData("CustomerPlacesOrder", "TestScript");
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
		Assert.assertEquals(actTitle, expTitle,"Checkout Page is fail");
		cp.orderNowAction();

		pu.acceptAlert(driver);
		pu.acceptAlert(driver);

		expTitle = eo.getExcelData("Pagetitlename", "orderspagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"My Orders Page is fail");
		ucp.customerLogout();
	}
}
