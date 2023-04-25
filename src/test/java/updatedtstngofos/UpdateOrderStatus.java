package updatedtstngofos;

import java.io.FileInputStream;
import java.io.IOException;

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
import objectRepo.AdminLoginPage;
import objectRepo.AdminPanelPage;
import objectRepo.AllOrdersPage;
import objectRepo.OrderUpdatePage;
import objectRepo.UserCommonPage;
import objectRepo.UserLoginPage;
import objectRepo.ViewOrderPage;

public class UpdateOrderStatus extends BaseClass{
	
	@Record(author = "Rohan")
	@Test(groups= {"sanity"})
	public void updateOrderStatus() {
		su.launchapplication(cusUrl);

		String expTitle = eo.getExcelData("Pagetitlename", "homepagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		String actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Home Page is fail");

		ucp.login();

		expTitle = eo.getExcelData("Pagetitlename", "loginpagetitle", "Titleslist");
		wu.waitUntilTitle(expTitle);
		actTitle = su.getTitle();
		Assert.assertEquals(actTitle, expTitle,"Login Page is fail");

		String cusName = eo.getExcelData("UpdateOrderStatus", "CusLoginid", "TestScript");
		String cusPassword = eo.getExcelData("UpdateOrderStatus", "CusPassword", "TestScript");

		ulp.loginAction(cusName, cusPassword);

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