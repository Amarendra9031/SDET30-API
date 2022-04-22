package Parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured .*;

public class FormParameter 
{
	@Test
	public void createProjectUsingFormParameter()
	{
		baseURI="http://localhost:8084/";
		given()
		.formParam("createdBy","Amarendra")
		.formParam("projectName", "IRCTC")
		.formParam("status","on going")
		.formParam("teamSize", 65)
		.contentType(ContentType.JSON)

		//action
		.when()
		.post("addProject")

		//validation

		.then().log().all();
	}
}
