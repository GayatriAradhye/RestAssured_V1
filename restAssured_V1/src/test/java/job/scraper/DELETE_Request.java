package job.scraper;
import static io.restassured.RestAssured.*;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class DELETE_Request extends DELETE_DATA {


	@Test(priority=1,dataProvider = "data_for_delete")
	public void Avalid_Delete(String jobId) {
		JSONObject request = new JSONObject();
		request.put("Job Id",jobId);
		given().queryParams(request).when().delete(baseURI).
		then().statusCode(200).log().all();

	}
	
	@Test(priority=2,dataProvider = "data_for_delete_neg")
	public void invalid_Delete(String jobId1) {
		JSONObject request = new JSONObject();
		request.put("Job Id",jobId1);
		given().queryParams(request).when().delete(baseURI).
		then().statusCode(404).log().all();

}
	}
