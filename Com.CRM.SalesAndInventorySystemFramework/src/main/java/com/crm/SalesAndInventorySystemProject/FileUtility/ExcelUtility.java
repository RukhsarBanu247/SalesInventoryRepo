package com.crm.SalesAndInventorySystemProject.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	/**
	 * This method is used fetch the data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Exception
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Exception
	{
		FileInputStream fis=new FileInputStream(".\\TestScriptData\\SaleAndInventorySystem_TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	/**
	 * This method is used to get the number of rows in the given sheet
	 * @param sheetName
	 * @return
	 * @throws Exception
	 */
	public int getRowCount(String sheetName) throws Exception
	{
		FileInputStream fis=new FileInputStream(".\\testData\\TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	/**
	 * This method is used to send the data to excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Exception
	 */
	public void setDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws Exception
	{
		FileInputStream fis=new FileInputStream(".\\testData\\TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
		
		//write mode
		FileOutputStream fos=new FileOutputStream(".\\testData\\TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
	
		
	}

}
