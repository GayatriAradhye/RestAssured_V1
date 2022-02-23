package job.scraper;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Get_Schema_Validation extends GET_DATA {
	@Test(dataProvider = "data_for_get")
	public void JobsGetAll(String domain, String uri,String status) {
	
	Response response =given().baseUri(domain).
			when().get(domain+uri);
	// Retrieve the body of the Response
	ResponseBody body = response.getBody();
	body.prettyPrint();
	
	Assert.assertEquals(response.getStatusCode(),200,"Response recieved successfully");
    Reporter.log("Response recieved successfully");
    
    String responsebodyasString = body.asString();
    assertThat("Json Schema",responsebodyasString.replaceAll("NaN", "null"),matchesJsonSchemaInClasspath("Get_Schema.json"));
    System.out.println("Validation Successful");
}

	private void assertThat(String string, String replaceAll, JsonSchemaValidator matchesJsonSchemaInClasspath) {
		// TODO Auto-generated method stub
		
	}
}