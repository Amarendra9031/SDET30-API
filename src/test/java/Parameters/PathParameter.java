package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter 
{
	@Test
	public void getSingleProject()
	{
		baseURI="http://localhost:8084/";
		given()
		.pathParam("pid", "TY_PROJ_1447")

		.when()
		.get("projects/{pid}")

		.then().log().all();
	}
}
