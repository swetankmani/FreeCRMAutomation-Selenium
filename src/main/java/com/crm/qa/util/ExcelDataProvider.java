package com.crm.qa.util;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	
	@Test(dataProvider="Test1Data")
	public void test1(String username,String password) {
		System.out.println(username+ " | "+password);
		
	}

	@DataProvider(name="Test1Data")
	public  static Object[][] getData() {
		String excelPath = "C:\\Users\\ASK\\eclipse-workspace\\JavaProjects\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\Test_data.xlsx";
		Object data[][]=testData(excelPath, "contacts");
		return data;
	}

	public static  Object[][] testData(String excelPath,String sheetName) {

		ExcelRead excel= new ExcelRead(excelPath,sheetName);
		int  rowcount = excel.getRowCount();
		int columncount = excel.getColCount();

		Object data[][]=new Object[rowcount-1][columncount];

		for(int i=1;i<rowcount;i++) {
			for(int j=0;j<columncount;j++) {

				String cellData= excel.getCellDataString(i, j);
				System.out.print(cellData+" | ");
				data[i-1][j]=cellData;
			}
			System.out.println();
		}
		return data;


	}

}
