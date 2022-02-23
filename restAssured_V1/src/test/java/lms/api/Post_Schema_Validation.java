package lms.api;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.hamcrest.Matcher;
import org.json.simple.JSONObject;

public class Post_Schema_Validation extends lms_POST_Data{

@Test(dataProvider="data_lms_post")
  

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
			.then().assertThat().body(matchesJsonSchemaInClasspath("response_body_Valid.json")).
       statusCode(200);
       
     
         
         System.out.println("JSON schema is validated successfully");
         Reporter.log("Schema Validation Successful");


}

}

