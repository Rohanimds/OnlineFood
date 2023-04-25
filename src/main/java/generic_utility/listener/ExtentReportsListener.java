package generic_utility.listener;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.model.Report;

import generic_utility.Base.BaseClass;
import generic_utility.annotation.Record;
import generic_utility.constants.Constants;
import generic_utility.enums.PropertyKey;
import generic_utility.fetchdata.FetchDataFromPropertyFile;
import generic_utility.instancetransfer.UtilityInstanceTransfer;
import generic_utility.javaUtility.JavaUtility;
import generic_utility.reportutility.ReportUtility;
/**
 * This class has all the methods related ITestListener and ISuitelistener
 * @author HP
 *
 */
public class ExtentReportsListener implements ITestListener, ISuiteListener {

	private ReportUtility report;
	public static ReportUtility sreport;

	@Override
	public void onStart(ITestContext context) {

		System.out.println("OnStart ---> Test");
	}

	@Override
	public void onStart(ISuite suite) {

		FetchDataFromPropertyFile propUtil = null;
		try {
			propUtil = new FetchDataFromPropertyFile(Constants.TEST_PROPERTY_FILE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		report=new ReportUtility();
		String overrideOrNot = propUtil.getPropertyStringData(PropertyKey.OVERRIDEREPORT);
		String randomName="";
		if(overrideOrNot.equalsIgnoreCase("no")) 
			randomName="_"+new JavaUtility().currentDate();
		report.init(randomName,
				propUtil.getPropertyStringData(PropertyKey.EXTENTREPORTTITLE),
				propUtil.getPropertyStringData(PropertyKey.EXTENTREPORTNAME), propUtil.getPropertyStringData(PropertyKey.BROWSER));
		sreport=report;
	}

	@Override
	public void onFinish(ISuite suite) {
		report.saveReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		report.createTest(result.getMethod().getMethodName());
		Record reportAnnotation= result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Record.class);
		
		report.addAuthor(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.author());
		report.addCategory(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		report.pass(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName() + "PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		report.fail(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName() + "FAIL", result.getThrowable());
		String screenshotPath = BaseClass.class.cast(result.getMethod().getInstance()).su.getScreenShot();
		report.attachScreenshot(UtilityInstanceTransfer.getExtentTest(),screenshotPath, result.getMethod().getMethodName(), "base64");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		report.skip(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName() + "SKIPPED");
		report.skip(UtilityInstanceTransfer.getExtentTest(),result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.saveReport();
	}

}
