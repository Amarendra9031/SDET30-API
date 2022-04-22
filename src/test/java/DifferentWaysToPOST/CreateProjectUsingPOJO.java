package DifferentWaysToPOST;

import org.testng.annotations.Test;

import CommanLibrary.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured .*;

public class CreateProjectUsingPOJO 
{
	@Test
	public void createProjectUsingPOJO()
	{

		JavaLibrary jLib = new JavaLibrary();
		baseURI="http://localhost:8084/";

		ProjectLibrary pLib = new ProjectLibrary("Amarendra", "Google "+jLib.getRandomNumber(), "Completed",25);

		given()
		.body(pLib)
		.contentType(ContentType.JSON)

		.when()
		.post("addProject")

		.then()
		.assertThat().statusCode(201)
		.log().all();
	}
}
