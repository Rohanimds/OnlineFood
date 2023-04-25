package fc_practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_utility.Base.BaseClass;
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

public class Order_From_HomePage2 extends BaseClass{

	@Test
	public void executeScript() {
		su.launchapplication(cusUrl);

		String actTitle = su.getTitle();
		String expTitle = eo.getExcelData("Pagetitlename", "homepagetitle", "Titleslist");
		vu.exactVerify(actTitle, expTitle, "page", "Home");
		 String selectDish = eo.getExcelData("Order_From_HomePage2", "Selectdish", "TestScript");

		 uhp.clickDishFromHomePage(selectDish);
    		
			String quantity = "1";
			dp.addToCartAction(selectDish);
		    dp.checkoutAction();
    		
           ucp.clickRegisterLink();
			
			expTitle = eo.getExcelData("Pagetitlename", "registrationpagetitle", "Titleslist");
			wu.waitUntilTitle(expTitle);
			actTitle = su.getTitle();
			vu.exactVerify(actTitle, expTitle, "page", "Registration ");
			
			Map<String, String> data = eo.getExcelData("CustomerPlacesOrder", "TestScript");
			String cusName=data.get("Name")+ranint;
//			System.out.println(cusName);
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
			vu.exactVerify(actTitle, expTitle, "page", "login");
			
			ulp.loginAction(cusName, cusPassword);
			
			expTitle = eo.getExcelData("Pagetitlename", "homepagetitle", "Titleslist");
			wu.waitUntilTitle(expTitle);
			actTitle = su.getTitle();
			vu.exactVerify(actTitle, expTitle, "page", "Home");
			
			ucp.clickRestaurantsLink();
			
			expTitle = eo.getExcelData("Pagetitlename", "restaurantspagetitle", "Titleslist");
			wu.waitUntilTitle(expTitle);
			actTitle = su.getTitle();
			vu.exactVerify(actTitle, expTitle, "page", "Restaurants");
			
			respage.clickRestaurantNameLink();
			
			expTitle = eo.getExcelData("Pagetitlename", "dishespagetitle", "Titleslist");
			wu.waitUntilTitle(expTitle);
			actTitle = su.getTitle();
			vu.exactVerify(actTitle, expTitle, "page", "Dishes");
			
			String orderdish = "Pink Spaghetti Gamberoni";
		    quantity = "1";
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
			vu.exactVerify(actTitle, expTitle, "page", "My Orders");
			ucp.customerLogout();
	}
}
