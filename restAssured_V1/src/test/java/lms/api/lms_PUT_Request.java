package lms.api;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class lms_PUT_Request extends lms_PUT_Data{
	@Test(priority=1,dataProvider = "data_lms_put")
	public void  ANew_Put_Request(String progId, String programName){
		JSONObject request = new JSONObject();
		request.put("programId",progId);
		request.put("programName",programName);
		
		given()
		.auth()
		.preemptive()
		.basic("admin", "password")
		.pathParam("programId", progId)
		.header("Accept", ContentType.JSON.getAcceptHeader())
		.contentType(ContentType.JSON)
		.body(request.toJSONString())
		//.when().put("https://lms-admin-rest-service.herokuapp.com/programs/{programId}")
		.when().put(baseURI+"/{programId}")
		.then().statusCode(200).log().body();



		
	}
	
	@Test(priority=2,dataProvider = "data_lms_put_neg")
	public void  Neg_Put_Request(String progId, String programName){
		JSONObject request = new JSONObject();
		request.put("programId",progId);
		request.put("programName",programName);
		
		given()
		.auth()
		.preemptive()
		.basic("admin", "password")
		.pathParam("programId", progId)
		.header("Accept", ContentType.JSON.getAcceptHeader())
		.contentType(ContentType.JSON)
		.body(request.toJSONString())
		//.when().put("https://lms-admin-rest-service.herokuapp.com/programs/{programId}")
		.when().put(baseURI+"/{programId}")
		.then().statusCode(400).log().body();



		
	}

}


