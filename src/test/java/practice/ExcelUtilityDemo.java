package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.vtiger.comcast.genericUtility.ExcelUtility;

public class ExcelUtilityDemo {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtility elib=new ExcelUtility();
		String data = elib.getDataFromExcel("Sheet1", 1, 1);
		System.out.println(data);
		
		
		int rowcount = elib.getRowCount("Sheet1");
		
		System.out.println(rowcount);
		
		
	}

}
