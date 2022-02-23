package job.scraper;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class POST_Request extends POST_DATA{
	
	

@Test(priority=1,dataProvider = "data_for_post")
  public void ANew_Post(String jobId, String JobTitle,String JobComapanyName,String JobLocation, String JobType,String JobDesc,String JobPostedTime) {
	  JSONObject request = new JSONObject();
	  request.put("Job Id",jobId);
	  request.put("Job Title",JobTitle);
	  request.put("Job Company Name",JobComapanyName);
	  request.put("Job Location",JobLocation);
	  request.put("Job Type",JobType);
	  request.put("Job Description",JobDesc);
	  request.put("Job Posted time",JobPostedTime);
	
	  given().queryParams(request).when().post(baseURI).
	  then().statusCode(200).log().body();
	 
	  	
	  	
  }
 
@Test(priority=2,dataProvider = "data_for_post_Neg")
 public void Existing_Post(String jobId1, String JobTitle1,String JobComapanyName1,String JobLocation1, String JobType1,String JobDesc1,String JobPostedTime1) {
	  JSONObject request = new JSONObject();
	  request.put("Job Id",jobId1);
	  request.put("Job Title",JobTitle1);
	  request.put("Job Company Name",JobComapanyName1);
	  request.put("Job Location",JobLocation1);
	  request.put("Job Type",JobType1);
	  request.put("Job Description",JobDesc1);
	  request.put("Job Posted time",JobPostedTime1);
  
Response response = get(baseURI);

	 	given().queryParams(request).when().post(baseURI).
	  then().statusCode(409).log().all();
	  	
	  	
	  	
 }
}
