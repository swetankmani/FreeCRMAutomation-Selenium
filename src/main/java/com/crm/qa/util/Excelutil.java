package com.crm.qa.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutil {
	
	public static void main(String[] args) {
		
		String projpath = System.getProperty("user.dir");
		System.out.println(projpath);
		ExcelRead excel = new ExcelRead(projpath + "src\\main\\java\\com\\crm\\qa\\testdata\\Test_data.xlsx", "contacts");
		excel.getRowCount();
		excel.getCellDataString(0, 1);
		excel.getCellDataNumber(0, 1);
		
	}

	
	
}
