package DifferentWaysToPOST;

import org.testng.annotations.Test;

import CommanLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured .*;

import java.util.HashMap;

public class CreateProjectUsingHashMap 
{
	@Test
	public void createProjectUsingHashMap()
	{

		JavaLibrary jLib = new JavaLibrary();
		baseURI="http://localhost:8084/"; 
		HashMap map=new HashMap();
		map.put("createdBy","kumar");
		map.put("projectName", "sony "+jLib.getRandomNumber());
		map.put("status", "Created");
		map.put("teamSize", 65);

		given()
		.body(map)
		.contentType(ContentType.JSON)

		.when()
		.post("/addProject")

		.then()
		.assertThat().statusCode(201)
		.log().all();

	}
}
