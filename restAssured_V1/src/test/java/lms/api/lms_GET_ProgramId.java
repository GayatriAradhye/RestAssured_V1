package lms.api;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class lms_GET_ProgramId extends lms_GET_PGRMID_Data {
	@Test(dataProvider = "Data_for_program_Id")

	public void A_lms_Get_PrgmID (String prgmId){

		given()
		.auth().basic("admin","password")
		.when().get(baseURI+prgmId)
		.then()
		.statusCode(200).log().body();	 
	}
	
	//----Negative Scenario
	
	@Test(dataProvider = "Data_for_program_Id_neg")

	public void Neg_lms_Get_PrgmID (String prgmId){

		given()
		.auth().basic("admin","password")
		.when().get(baseURI+prgmId)
		.then()
		.statusCode(400).log().body();	 
	}


}
