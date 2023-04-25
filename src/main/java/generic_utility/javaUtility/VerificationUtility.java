package generic_utility.javaUtility;
/**
 * This class has all the generic methods related to verification
 * @author HP
 *
 */
public class VerificationUtility {
/**
 * This method is used to compare the actual result with expected result using equals
 * @param actual
 * @param expected
 * @param strategy
 * @param pageNameOrTCName
 */
public void exactVerify(String actual, String expected, String strategy,String pageNameOrTCName) {
	if(strategy.equalsIgnoreCase("TC")) {
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println(pageNameOrTCName+"TC is pass");
		}else {
			System.out.println(pageNameOrTCName+"TC is fail");
		}
	}else if(strategy.equalsIgnoreCase("page")){
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println(pageNameOrTCName+"Page is pass");
		}else {
			System.out.println(pageNameOrTCName+"Page is fail");
		}
	}else if(strategy.equalsIgnoreCase("element")) {
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println(pageNameOrTCName+"element is pass");
		}else {
			System.out.println(pageNameOrTCName+"element is fail");
		}
	}
}

/**
 * This method is used to compare the actual result with expected result using contains
 * @param actual
 * @param expected
 * @param strategy
 * @param pageNameOrTCName
 */
public void partialVerify(String actual, String expected, String strategy,String pageNameOrTCName) {
	if(strategy.equalsIgnoreCase("TC")) {
		if(actual.contains(expected)) {
			System.out.println(pageNameOrTCName+"TC is pass");
		}else {
			System.out.println(pageNameOrTCName+"TC is fail");
		}
	}else if(strategy.equalsIgnoreCase("page")){
		if(actual.contains(expected)) {
			System.out.println(pageNameOrTCName+"Page is pass");
		}else {
			System.out.println(pageNameOrTCName+"Page is fail");
		}
	}else if(strategy.equalsIgnoreCase("element")) {
		if(actual.contains(expected)) {
			System.out.println(pageNameOrTCName+"element is pass");
		}else {
			System.out.println(pageNameOrTCName+"element is fail");
		}
	}
}
}
