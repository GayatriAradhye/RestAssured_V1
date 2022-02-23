package job.scraper;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DELETE_DATA {
	@DataProvider(name = "data_for_delete")
	public Object[][] dataForDelete() throws IOException {
		baseURI="https://jobs123.herokuapp.com";
		String Excelpath = "./ExcelData/Job_Scraper.xlsx/";    
		XSSFWorkbook workbook = new XSSFWorkbook(Excelpath);
		System.out.println(workbook);
		XSSFSheet deletesheet = workbook.getSheet("DeleteSheet");
		DataFormatter formatter= new DataFormatter();
		int rowNum = deletesheet.getLastRowNum();
		int colNum = deletesheet.getRow(0).getLastCellNum();
		System.out.println("the row count is " +rowNum);
		System.out.println("The Column count is "+colNum);

		baseURI = "https://jobs123.herokuapp.com/Jobs";
		String data[][]=new String [rowNum][colNum];

		for (int i=1;i<=rowNum;i++) {
			for(int j=0;j<colNum;j++) {

				String parameter = (formatter.formatCellValue(deletesheet.getRow(i).getCell(j)));
				System.out.println("\n"+parameter);
				data[i-1][j]= (formatter.formatCellValue(deletesheet.getRow(i).getCell(j)));
				workbook.close();
			}} 
		return(data);

	}
	
	@DataProvider(name = "data_for_delete_neg")
	public Object[][] dataForDelete_Neg() throws IOException {
		baseURI="https://jobs123.herokuapp.com";
		String Excelpath = "./ExcelData/Job_Scraper.xlsx/";    
		XSSFWorkbook workbook = new XSSFWorkbook(Excelpath);
		System.out.println(workbook);
		XSSFSheet deletesheet = workbook.getSheet("DeleteSheetNeg");
		DataFormatter formatter= new DataFormatter();
		int rowNum = deletesheet.getLastRowNum();
		int colNum = deletesheet.getRow(0).getLastCellNum();
		System.out.println("the row count is " +rowNum);
		System.out.println("The Column count is "+colNum);

		baseURI = "https://jobs123.herokuapp.com/Jobs";
		String data[][]=new String [rowNum][colNum];

		for (int i=1;i<=rowNum;i++) {
			for(int j=0;j<colNum;j++) {

				String parameter = (formatter.formatCellValue(deletesheet.getRow(i).getCell(j)));
				System.out.println("\n"+parameter);
				data[i-1][j]= (formatter.formatCellValue(deletesheet.getRow(i).getCell(j)));
				workbook.close();
			}} 
		return(data);

	}
}
 
 