package com.vtiger.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * it is develooped using Apache POI to read the data from excel files
 * @author Rahil
 *
 */

public class ExcelUtility {
	/**
	 * it is used to read the data from excel file using below parameters
	 * @param sheetName
	 * @param rowNum
	 * @param CellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int CellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/vtiger.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(CellNum).getStringCellValue();
		wb.close();
		return value;
		
	}
	
	/**
	 * it is used to get last used row number on a specified sheet
	 * @param sheetName
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./data/vtiger.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
		
	}
	
	/**
	 * it is used to set/write the value inside excel file
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
		
	public void setDataExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException
		{
		FileInputStream fis=new FileInputStream("./data/vtiger.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream("./data/vtiger.xlsx");
		wb.write(fos);
		wb.close();
		
			
		}
		
	}

