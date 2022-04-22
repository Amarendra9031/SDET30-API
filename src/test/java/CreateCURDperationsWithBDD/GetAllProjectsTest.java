package CreateCURDperationsWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAllProjectsTest
{
	@Test
	public void getAllProjectsTest()
	{

		baseURI="http://localhost:8084/";
		when()
		.get("projects")

		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
	}
}
