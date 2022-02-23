package lms.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.given;
public class lms_GET_Request extends lms_GET_Data{
	@Test(priority=1,dataProvider="data_for_positive")

	public void A_Valid_Get_REquest(String userId, String pswd,String uri) {

		given()
		.auth().basic(userId,pswd)
		.when().get(uri)
		.then()
		.statusCode(200).log().body();

	}

	//------for negative scenario

	//@Test(priority=2,dataProvider="Data_for_negative")

	public void invalid_Get_REquest(String userId, String pswd,String uri) {

		given()
		.auth().basic(userId,pswd)
		.when().get(uri)
		.then()
		.statusCode(401).log().all();

	}
}





