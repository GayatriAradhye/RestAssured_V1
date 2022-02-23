package job.scraper;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class PUT_DATA {
	@DataProvider(name = "data_for_put")
	public Object[][] dataForPut() throws IOException {
		String Excelpath = "./ExcelData/Job_Scraper.xlsx/";    
		XSSFWorkbook workbook = new XSSFWorkbook(Excelpath);
		System.out.println(workbook);
		XSSFSheet putsheet = workbook.getSheet("put_Sheet");
		DataFormatter formatter= new DataFormatter();
		int rowNum = putsheet.getLastRowNum();
		int colNum = putsheet.getRow(0).getLastCellNum();
		System.out.println("the row count is " +rowNum);
		System.out.println("The Column count is "+colNum);

		baseURI = "https://jobs123.herokuapp.com/Jobs";
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
	
	@DataProvider(name = "data_for_put_neg")
	public Object[][] dataForPutNeg() throws IOException {
		String Excelpath = "./ExcelData/Job_Scraper.xlsx/";    
		XSSFWorkbook workbook = new XSSFWorkbook(Excelpath);
		System.out.println(workbook);
		XSSFSheet putsheet = workbook.getSheet("put_neg");
		DataFormatter formatter= new DataFormatter();
		int rowNum = putsheet.getLastRowNum();
		int colNum = putsheet.getRow(0).getLastCellNum();
		System.out.println("the row count is " +rowNum);
		System.out.println("The Column count is "+colNum);

		baseURI = "https://jobs123.herokuapp.com/Jobs";
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