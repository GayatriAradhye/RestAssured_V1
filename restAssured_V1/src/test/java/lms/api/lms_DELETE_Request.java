package lms.api;


import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class lms_DELETE_Request extends lms_DELETE_Data{
  @Test(priority=1,dataProvider = "data_lms_delete")
  public void A_New_Delete_Request(String ProgramID) {
	  JSONObject request = new JSONObject();
		request.put("programId",ProgramID);
		
		
		given()
		.auth()
		.preemptive()
		.basic("admin", "password")
		.pathParam("programId", ProgramID)
		.header("Accept", ContentType.JSON.getAcceptHeader())
		.contentType(ContentType.JSON)
		.body(request.toJSONString())
		//.when().put("https://lms-admin-rest-service.herokuapp.com/programs/{programId}")
		.when().delete(baseURI+"/{programId}")
		.then().statusCode(200).log().body();
		Assert.assertEquals(200, 200);


  }
 	  @Test(priority=2,dataProvider = "data_lms_delete_neg")
	  public void Neg_Delete_Request(String ProgramID) {
		  JSONObject request = new JSONObject();
			request.put("programId",ProgramID);
			
			
			given()
			.auth()
			.preemptive()
			.basic("admin", "password")
			.pathParam("programId", ProgramID)
			.header("Accept", ContentType.JSON.getAcceptHeader())
			.contentType(ContentType.JSON)
			.body(request.toJSONString())
			//.when().put("https://lms-admin-rest-service.herokuapp.com/programs/{programId}")
			.when().delete(baseURI+"/{programId}")
			.then().statusCode(400).log().body();


	  }
}
