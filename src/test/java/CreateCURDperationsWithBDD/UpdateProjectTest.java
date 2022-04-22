package CreateCURDperationsWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static  io.restassured.RestAssured .*;
import io.restassured.http.ContentType;

public class UpdateProjectTest
{
	@Test
	public void updateProjectTest()
	{
	
		//Step 1: Create the pre requisites--request Body
				JSONObject jobj = new JSONObject();
				jobj.put("createdBy", "kumarAmarendra");
				jobj.put("projectName", "paytm");
				jobj.put("status", "Completed");
				jobj.put("teamSize",45);
				
				baseURI="http://localhost:8084/";
				
				given()
				.body(jobj)
				.contentType(ContentType.JSON)
				
				
				.when()//step 2:perform action
				.post("projects/TY_PROJ_2202")
				
				.then()//step 3: validate
				.assertThat()
				.contentType(ContentType.JSON)
				.statusCode(200)
				.log().all();
	}
}
