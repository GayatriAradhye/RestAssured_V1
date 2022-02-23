package lms.api;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class lms_PUT_Data {
	@DataProvider (name = "data_lms_put")
	public Object[][] dataForPut() throws IOException {
		baseURI="https://lms-admin-rest-service.herokuapp.com/programs";
		String Excelpath = "./ExcelData/lms_API.xlsx/";    
		XSSFWorkbook workbook = new XSSFWorkbook(Excelpath);
		System.out.println(workbook);
		XSSFSheet putsheet = workbook.getSheet("put_lms");
		DataFormatter formatter= new DataFormatter();
		int rowNum = putsheet.getLastRowNum();
		int colNum = putsheet.getRow(0).getLastCellNum();
		System.out.println("the row count is " +rowNum);
		System.out.println("The Column count is "+colNum);
		String data[][]=new String [rowNum][colNum];

		for (int i=1;i<=rowNum;i++) {
			for(int j=0;j<colNum;j++) {

				String parameter = (formatter.formatCellValue(putsheet.getRow(i).getCell(j)));
				System.out.println("\n"+parameter);
				data[i-1][j]= (formatter.formatCellValue(putsheet.getRow(i).getCell(j)));
				workbook.close();
			}} 
		return(data);
		
	}

	@DataProvider (name = "data_lms_put_neg")
	public Object[][] dataForPut_Neg() throws IOException {
		baseURI="https://lms-admin-rest-service.herokuapp.com/programs";
		String Excelpath = "./ExcelData/lms_API.xlsx/";    
		XSSFWorkbook workbook = new XSSFWorkbook(Excelpath);
		System.out.println(workbook);
		XSSFSheet putsheet = workbook.getSheet("put_lms_Neg");
		DataFormatter formatter= new DataFormatter();
		int rowNum = putsheet.getLastRowNum();
		int colNum = putsheet.getRow(0).getLastCellNum();
		System.out.println("the row count is " +rowNum);
		System.out.println("The Column count is "+colNum);
		String data[][]=new String [rowNum][colNum];

		for (int i=1;i<=rowNum;i++) {
			for(int j=0;j<colNum;j++) {

				String parameter = (formatter.formatCellValue(putsheet.getRow(i).getCell(j)));
				System.out.println("\n"+parameter);
				data[i-1][j]= (formatter.formatCellValue(putsheet.getRow(i).getCell(j)));
				workbook.close();
			}} 
		return(data);

	}

}
