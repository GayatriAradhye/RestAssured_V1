package lms.api;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class lms_POST_Data {
	@DataProvider (name = "data_lms_post")
	public Object[][] dataForPost() throws IOException {
		//baseURI="https://lms-admin-rest-service.herokuapp.com/programs";
		String Excelpath = "./ExcelData/lms_API.xlsx/";    
		XSSFWorkbook workbook = new XSSFWorkbook(Excelpath);
		System.out.println(workbook);
		XSSFSheet postsheet = workbook.getSheet("post_lms");
		DataFormatter formatter= new DataFormatter();
		int rowNum = postsheet.getLastRowNum();
		int colNum = postsheet.getRow(0).getLastCellNum();
		System.out.println("the row count is " +rowNum);
		System.out.println("The Column count is "+colNum);
		String data[][]=new String [rowNum][colNum];

		for (int i=1;i<=rowNum;i++) {
			for(int j=0;j<colNum;j++) {

				String parameter = (formatter.formatCellValue(postsheet.getRow(i).getCell(j)));
				System.out.println("\n"+parameter);
				data[i-1][j]= (formatter.formatCellValue(postsheet.getRow(i).getCell(j)));
				workbook.close();
			}} 
		return(data);

	}
	
	@DataProvider (name = "data_lms_post_neg")
	public Object[][] dataForPost_Neg() throws IOException {
		//baseURI="https://lms-admin-rest-service.herokuapp.com/programs";
		String Excelpath = "./ExcelData/lms_API.xlsx/";    
		XSSFWorkbook workbook = new XSSFWorkbook(Excelpath);
		System.out.println(workbook);
		XSSFSheet postsheet = workbook.getSheet("post_lms_neg");
		DataFormatter formatter= new DataFormatter();
		int rowNum = postsheet.getLastRowNum();
		int colNum = postsheet.getRow(0).getLastCellNum();
		System.out.println("the row count is " +rowNum);
		System.out.println("The Column count is "+colNum);
		String data[][]=new String [rowNum][colNum];

		for (int i=1;i<=rowNum;i++) {
			for(int j=0;j<colNum;j++) {

				String parameter = (formatter.formatCellValue(postsheet.getRow(i).getCell(j)));
				System.out.println("\n"+parameter);
				data[i-1][j]= (formatter.formatCellValue(postsheet.getRow(i).getCell(j)));
				workbook.close();
			}} 
		return(data);

	}

}

