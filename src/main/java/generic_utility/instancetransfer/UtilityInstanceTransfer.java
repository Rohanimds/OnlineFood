package generic_utility.instancetransfer;

import com.aventstack.extentreports.ExtentTest;
/**
 * This class has all the methods for instance transfer
 * @author HP
 *
 */
public class UtilityInstanceTransfer {
/**
 * This method is used to create thread local variable
 */
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
	
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}
	/**
	 * This method is used to set extent test
	 * @param setExtentTest
	 */
	public static void setExtentTest(ExtentTest setExtentTest) {
		extentTest.set(setExtentTest);
	}
	
}
