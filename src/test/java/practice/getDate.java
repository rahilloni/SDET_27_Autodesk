package practice;

import com.vtiger.comcast.genericUtility.JavaUtility;

public class getDate {
	
	public static void main(String[] args) {
		
		JavaUtility jlib=new JavaUtility();
		String time = jlib.getSytemDateAndTime();
		
		System.out.println(time);
		
		int ran = jlib.getRandomNumber();
		System.out.println(ran);
		
		String dateandtime = jlib.getSystemDateWithFormat();
		
		System.out.println(dateandtime);
	}

}
