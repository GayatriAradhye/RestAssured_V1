package lms.api;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;
public class Get_Schema_Validation extends lms_GET_Data{

@Test(dataProvider = "data_for_positive")
	public void A_Valid_Get_REquest(String userid,String pswd, String uri) {

		given()
		.auth().basic(userid,pswd)
		.when().get(uri)
		.then().assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
		.statusCode(200);

	}


}