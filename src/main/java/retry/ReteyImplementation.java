package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReteyImplementation implements IRetryAnalyzer{
int count;
	@Override
	public boolean retry(ITestResult result) {
		int maxCount=2;
		if(count<maxCount) {
			count++;
			return true;
		}
		return false;
	}
	
}
