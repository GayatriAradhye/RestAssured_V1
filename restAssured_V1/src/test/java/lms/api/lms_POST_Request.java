package lms.api;


import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class lms_POST_Request extends lms_POST_Data {
	@Test(priority=1,dataProvider = "data_lms_post")
	public void ANew_Post_lms(String programId, String programName,String programDescription,String online) {
		JSONObject request = new JSONObject();
		request.put("programId",programId);
		request.put("programName",programName);
		request.put("programDescription",programDescription);
		request.put("online",online);
		baseURI="https://lms-admin-rest-service.herokuapp.com/programs";		

		 		 given()
				.auth()
				.preemptive()
				.basic("admin", "password")
				.header("Accept", ContentType.JSON.getAcceptHeader())
				.contentType(ContentType.JSON)
				.body(request.toJSONString())
				.when().post(baseURI)
				.then().statusCode(200).log().body();

	}
	
	@Test(priority=2,dataProvider = "data_lms_post_neg")// use alphanumeric values for negative scenario.
	public void _Neg_New_Post_lms(String programId, String programName,String programDescription,String online) {
		JSONObject request = new JSONObject();
		request.put("programId",programId);
		request.put("programName",programName);
		request.put("programDescription",programDescription);
		request.put("online",online);
		baseURI="https://lms-admin-rest-service.herokuapp.com/programs";		

		 		 given()
				.auth()
				.preemptive()
				.basic("admin", "password")
				.header("Accept", ContentType.JSON.getAcceptHeader())
				.contentType(ContentType.JSON)
				.body(request.toJSONString())
				.when().post(baseURI)
				.then().statusCode(400).log().body();
		 		 

	}
	
}
