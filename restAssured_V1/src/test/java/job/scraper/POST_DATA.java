package job.scraper;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class POST_DATA {

	//@DataProvider(name = "data_for_post")
	//public Object[][] dataForPost() {
	//	Object[][] data = new Object[2][7];//first square is row& second is column
	//	//---first row data---
	//	data[0][0] = "Job Id";
	//	data[0][1] = "1986";
	//	//----second row data---
	//	data[1][0]= "Job Title";
	//	data[1][1]="Manager";
	//	return data;

	//return new Object[][] {
	//{1986, "Manager"}
	//};
	//}
	@DataProvider(name = "data_for_post")
	public Object[][] dataForPost() throws IOException {
		baseURI="https://jobs123.herokuapp.com";
		String Excelpath = "./ExcelData/Job_Scraper.xlsx/";    
		XSSFWorkbook workbook = new XSSFWorkbook(Excelpath);
		System.out.println(workbook);
		XSSFSheet postsheet = workbook.getSheet("postSheet");
		DataFormatter formatter= new DataFormatter();
		int rowNum = postsheet.getLastRowNum();
		int colNum = postsheet.getRow(0).getLastCellNum();
		System.out.println("the row count is " +rowNum);
		System.out.println("The Column count is "+colNum);
		baseURI = "https://jobs123.herokuapp.com/Jobs";
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
	//-----data for negative senario
	@DataProvider(name = "data_for_post_Neg")
	public Object[][] dataForPost_Neg() throws IOException {
		baseURI="https://jobs123.herokuapp.com";
		String Excelpath = "./ExcelData/Job_Scraper.xlsx/";    
		XSSFWorkbook workbook = new XSSFWorkbook(Excelpath);
		System.out.println(workbook);
		XSSFSheet postsheet_neg = workbook.getSheet("post_neg");
		DataFormatter formatter= new DataFormatter();
		int rowNum = postsheet_neg.getLastRowNum();
		int colNum = postsheet_neg.getRow(0).getLastCellNum();
		System.out.println("the row count is " +rowNum);
		System.out.println("The Column count is "+colNum);
		baseURI = "https://jobs123.herokuapp.com/Jobs";
		String data[][]=new String [rowNum][colNum];

		for (int i=1;i<=rowNum;i++) {
			for(int j=0;j<colNum;j++) {

				String parameter = (formatter.formatCellValue(postsheet_neg.getRow(i).getCell(j)));
				//System.out.println("\n"+parameter);
				data[i-1][j]= (formatter.formatCellValue(postsheet_neg.getRow(i).getCell(j)));
				workbook.close();
			}} 
		return(data);

	}
}





