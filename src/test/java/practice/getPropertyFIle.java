package practice;

import java.io.IOException;

import com.vtiger.comcast.genericUtility.FileUtility;

public class getPropertyFIle {
	
	public static void main(String[] args) throws IOException {
		
		FileUtility flib=new FileUtility();
		String url = flib.getPropertyKeyValue("USERNAME");
		System.out.println(url);
	}

}
