package CreateCURDperationsWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured .*;

public class GetSingleProjectsTest 
{
	@Test
	public void getSingleProjectsTest()
	{
		baseURI="http://localhost:8084/";
		when()
		.get("projects/TY_PROJ_2202")
		.then()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();	
	}
}
