package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	static String projpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelRead(String excelPath,String  sheetName) {
		try {
			
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch(Exception e) {

			e.printStackTrace();

		}


	}
	
	//method for row count

	public static int getRowCount(){
		
		int rowCount=0;

		try {

			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows:-" );
			

		} catch(Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
		return rowCount;
	}

	//method  for  colcount
	
	public static int getColCount(){
		
		int colCount =0;

		try {

			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of rows:-");
			

		} catch(Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
		return colCount;
	}

	
	//Method for string value
	
	public static String getCellDataString(int rowNum,int colNum) {
		
		String cellData = null;  

		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(cellData);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;
	}

	///method for number
	
	public static void getCellDataNumber(int  rowNum,int colNum) {

		try {
			double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(cellData);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}






}
