package com.vtiger.comcast.genericUtility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Rahil
 *
 */

public class JavaUtility {
	/**
	 * it is used to generate random number
	 * @return int data
	 */
	
	public int getRandomNumber() {
		Random random=new Random();
		int RanNum=random.nextInt();
		return RanNum;
	}
	
	/**
	 * used to get system date and time in IST format
	 * @return 
	 */
	
	public String getSytemDateAndTime() {
		
		Date date=new Date();
		return date.toString();
	
	}
	/**
	 * used to get system date and time in YYYY-MM-DD foramt
	 * @return 
	 */
	
	public String getSystemDateWithFormat() {
		Date date=new Date();
		String DateAndTime=date.toString();
		
		String YYYY = DateAndTime.split(" ")[5];
		String DD = DateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		
		String finalDate = YYYY+"-"+MM+"-"+DD;
		return finalDate;
	}

}
