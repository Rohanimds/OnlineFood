package updatedtstngofos;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.Base.BaseClass;
import generic_utility.annotation.Record;

public class RegisterUser extends BaseClass{
	
	@Record(author = "Rohan")
	@Test(groups= {"regression", "major"})
	public void registerUser() {
		su.launchapplication(cusUrl);

		String expTitle = eo.getExcelData("Pagetitlename", "homepagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		String actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Home Page is fail");
		
		ucp.clickRegisterLink();

	 expTitle = eo.getExcelData("Pagetitlename", "registrationpagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle=su.getTitle();
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
		
		ucp.customerLogout();
}
}
