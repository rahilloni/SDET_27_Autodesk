package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class woorkbook {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		 
		FileInputStream fis=new FileInputStream("./data/autodesk.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		
		System.out.println(value);
		
	}

}
