package lms.api;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class post_responsebody_ValidationTest extends lms_POST_Data {
  @Test(dataProvider="data_lms_post")
  public void ANew_Post_lms(String programid, String programname,String programDescription,String online) {
		JSONObject request = new JSONObject();
		request.put("programId",programid);
		request.put("programName",programname);
		request.put("programDescription",programDescription);
		request.put("online",online);
		baseURI="https://lms-admin-rest-service.herokuapp.com/programs";		
		      Response body= given()
				.auth()
				.preemptive()
				.basic("admin", "password")
				.header("Accept", ContentType.JSON.getAcceptHeader())
				.contentType(ContentType.JSON)
				.body(request.toJSONString())
				.when().post(baseURI);
				//then()
				//.assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
				//.then().statusCode(200);	
		       
		       String programId = body.jsonPath().getString("programId");//method1
				 Reporter.log("First retrieved program id   "+programId);
				 Assert.assertNotNull(programId);
		       JsonPath afterpost = body.jsonPath();//method2
		       String prgName = afterpost.get("programName");
		       String prgDesc = afterpost.getString("programDescription");
		      Boolean onlineValue = afterpost.get("online");
		       
		       Assert.assertEquals(prgName, programname);
		       Reporter.log("ProgramName "+prgName);
		       Assert.assertEquals(prgDesc, programDescription);
		       Reporter.log("ProgramDescription "+programDescription);
		       boolean online1 = Boolean.parseBoolean(online);
		       Assert.assertEquals(onlineValue, online1);
		       Reporter.log("Online "+online1);
  }
 }
		       
		      
		        
				 
		    
		 		 
		 		

		         
		       
	       
	     
	         
	        


 
