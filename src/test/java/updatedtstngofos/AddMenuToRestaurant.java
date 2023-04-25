package updatedtstngofos;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.Base.BaseClass;
import generic_utility.annotation.Record;
import generic_utility.constants.Constants;

public class AddMenuToRestaurant extends BaseClass{

	@Record(author = "Rohan")
	@Test(groups= {"regression", "major"})
	public void addMenuToRestaurant() throws Throwable {
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
		String filePath =Constants.GET_IMAGE;
		
		

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
	}
}
