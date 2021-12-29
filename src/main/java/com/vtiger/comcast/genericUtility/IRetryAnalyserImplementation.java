package com.vtiger.comcast.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class provides implementation for iRetryAnalzer
 * @author 91935
 *
 */

public class IRetryAnalyserImplementation implements IRetryAnalyzer {
	int count=0;
	int retryCount=2;
	
	@Override
	public boolean retry(ITestResult result) {
		
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
