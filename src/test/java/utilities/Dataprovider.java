package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	
	//DataProvider 1
	
	@DataProvider(name="LoginDataProvider")
	public String[][] getData() throws IOException{
	
		String path = ".//testdata//Opencart_LoginData.xlsx";
		
		ExcelUtility xlUtil = new ExcelUtility(path); // creating object for ExcelUtility class
		
		int rows = xlUtil.getRowCount("Sheet1"); // total row count
		int columns = xlUtil.getCellCount("Sheet1", 1); // total column count
		
		String LoginData[][] = new String[rows][columns]; // Creating string array to return data
		
		for(int r = 1; r<=rows;r++) {    //running for loop to travel rows and columns of sheet1
			
			for(int c = 0; c<columns;c++) {
				
				LoginData[r-1][c] = xlUtil.getCellData("Sheet1", r, c); //Entering sheet data in string matrix
			}
		}
		
		return LoginData;		
		
	}

}
