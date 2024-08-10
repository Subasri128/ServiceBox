package ServiceBox.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


//To avoid flakiness same test can be rerun until a 
//condition is satisfied to acheive this Iretryanalyzer is used.

public class retryListeners implements IRetryAnalyzer {
	int count =0, maxTry =2;//times to run
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxTry) {
			count++;
			return true;
		}
		
		return false;
	}

}
