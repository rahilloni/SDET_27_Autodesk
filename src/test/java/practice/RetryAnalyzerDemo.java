package practice;

import org.junit.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerDemo {
	
	@Test(retryAnalyzer = com.vtiger.comcast.genericUtility.IRetryAnalyserImplementation.class)
	public void retryAnalyerimp() {
		System.out.println("Retry Analyzer");
		Assert.fail();
		
	}

}
