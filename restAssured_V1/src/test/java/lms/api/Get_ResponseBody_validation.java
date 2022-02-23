package lms.api;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Get_ResponseBody_validation extends lms_GET_PGRMID_Data{
	@Test//(dataProvider="Data_for_program_Id")
	public void responseBody_validate(){
		baseURI= "https://lms-admin-rest-service.herokuapp.com/programs";
		Response response=  given()
		.auth()
		.preemptive()
		.basic("admin","password")
		.when().get(baseURI);
		
		//.then().assertThat().body(matchesJsonSchemaInClasspath("Get_Responsebody.json"))
		//.statusCode(200).log().body();	 
		

				 // Retrieve the body of the Response
				 ResponseBody body = response.getBody();


				 //to print the response body
				 body.prettyPrint();

				 //To validate the response body
				 String programId = body.jsonPath().getString("programId[1]");
				 Reporter.log("First retrieved program id   "+programId);
				 Assert.assertNotNull(programId);

				 String programName= body.jsonPath().getString("programName[1]");
				 Reporter.log("First retrieved program Name  "+programName);
				

				 String programDesc= body.jsonPath().getString("programDescription[1]");
				 Reporter.log("First retrieved program Description  "+programDesc);
				

				 String isOnline= body.jsonPath().getString("online[1]");
				 Reporter.log("First retrieved isOnline status  "+isOnline);
				 


				 int status= response.getStatusCode();
				 SoftAssert a = new SoftAssert();
				 a.assertEquals(status,200,"Correct status code returned");
				 Reporter.log("Expected Status code matches with the actual status code " +status);
	}
	
}
