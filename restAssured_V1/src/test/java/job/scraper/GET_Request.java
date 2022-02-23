package job.scraper;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;




public class GET_Request extends GET_DATA{
	@Test(priority=1,dataProvider = "data_for_get")
	//------Sending GET request with Valid URI
	public void A_valid_getRequest(String domain, String uri,String status) {
		
		int StatusCode = Integer.parseInt(status);
		given().baseUri(domain).
		when().get(domain+uri).
		then().statusCode(StatusCode).log().all();
		Assert.assertEquals(200, StatusCode,"Valid Status Code");
	}

	//------Sending GET request with Invalid URI

	@Test(priority=2,dataProvider = "Data_for_negative")
	public void invalid_getRequest (String domain, String uri) {
		given().baseUri(domain).when().get(domain+uri).
		then().statusCode(404).log().all();
	}
	
	
	} 