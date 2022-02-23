package job.scraper;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PUT_Request extends PUT_DATA{


	@Test(priority=1,dataProvider = "data_for_put")
	public void AValid_Put_Rerquest(String jobId, String JobTitle,String JobCompanyName) {
		JSONObject request = new JSONObject();
		request.put("Job Id",jobId);
		request.put("Job Title",JobTitle);
		request.put("Job Company Name",JobCompanyName);
		//		  request.put("Job Location",JobLocation);
		//		  request.put("Job Type",JobType);
		//		  request.put("Job Description",JobDesc);
		//		  request.put("Job Posted time",JobPostedTime);
		//		  

		baseURI = "https://jobs123.herokuapp.com/Jobs";
		given().queryParams(request).when().put(baseURI).
		then().statusCode(200).log().all();

	}
	@Test(priority=2,dataProvider = "data_for_put_neg")
	public void Invalid_Put_Request(String jobId, String JobTitle) {
		JSONObject request = new JSONObject();
		request.put("Job Id",jobId);
		request.put("Job Title",JobTitle);
		//		  request.put("Job Company Name",JobComapanyName);
		//		  request.put("Job Location",JobLocation);
		//		  request.put("Job Type",JobType);
		//		  request.put("Job Description",JobDesc);
		//		  request.put("Job Posted time",JobPostedTime);
		//		  

		given().queryParams(request).when().put(baseURI).
		then().statusCode(404).log().all();
	}}
