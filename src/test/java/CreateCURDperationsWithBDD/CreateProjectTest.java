package CreateCURDperationsWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest 
{
	@Test
	public void createProjectTest()
	{

		//Step 1: Create the pre requisites--request Body
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "kumar");
		jobj.put("projectName", "paytm");
		jobj.put("status", "Completed");
		jobj.put("teamSize",12);
		
		baseURI="http://localhost:8084/";
		
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		
		.when()//step 2:perform action
		.post("addProject")
		
		.then()//step 3: validate
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
	}
}
