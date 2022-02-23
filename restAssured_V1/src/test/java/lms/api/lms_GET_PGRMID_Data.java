package lms.api;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class lms_GET_PGRMID_Data {

	
	
		//-------data for Get data with Program ID-----
		
		@DataProvider(name = "Data_for_program_Id")
		public Object[][] dataForGet_PrgmId() throws IOException {
			baseURI = "https://lms-admin-rest-service.herokuapp.com/programs/";
			String Excelpath = "./ExcelData/lms_API.xlsx/";     
			XSSFWorkbook workbook = new XSSFWorkbook(Excelpath);
			System.out.println(workbook);
			XSSFSheet getsheet = workbook.getSheet("get_programId");
			DataFormatter formatter= new DataFormatter();
			int rowNum = getsheet.getLastRowNum();
			int colNum = getsheet.getRow(0).getLastCellNum();
			System.out.println("the row count is " +rowNum);
			System.out.println("The Column count is "+colNum);
			String data[][]=new String [rowNum][colNum];

			for (int i=1;i<=rowNum;i++) {
				for(int j=0;j<colNum;j++) {

			String parameter = (formatter.formatCellValue(getsheet.getRow(i).getCell(j)));
			System.out.println("\n"+parameter);
			data[i-1][j]= (formatter.formatCellValue(getsheet.getRow(i).getCell(j)));
			workbook.close();
				}} 
			return(data);

		}
		//--------Negative data for GET Program ID
		
		@DataProvider(name = "Data_for_program_Id_neg")
		public Object[][] dataForGet_PrgmId_neg() throws IOException {
			baseURI = "https://lms-admin-rest-service.herokuapp.com/programs/";
			String Excelpath = "./ExcelData/lms_API.xlsx/";     
			XSSFWorkbook workbook = new XSSFWorkbook(Excelpath);
			System.out.println(workbook);
			XSSFSheet getsheet = workbook.getSheet("get_progId_neg");
			DataFormatter formatter= new DataFormatter();
			int rowNum = getsheet.getLastRowNum();
			int colNum = getsheet.getRow(0).getLastCellNum();
			System.out.println("the row count is " +rowNum);
			System.out.println("The Column count is "+colNum);
			String data[][]=new String [rowNum][colNum];

			for (int i=1;i<=rowNum;i++) {
				for(int j=0;j<colNum;j++) {

			String parameter = (formatter.formatCellValue(getsheet.getRow(i).getCell(j)));
			System.out.println("\n"+parameter);
			data[i-1][j]= (formatter.formatCellValue(getsheet.getRow(i).getCell(j)));
			workbook.close();
				}} 
			return(data);

		}

}
