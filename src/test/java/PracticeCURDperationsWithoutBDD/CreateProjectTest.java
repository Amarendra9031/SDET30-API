package PracticeCURDperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest 
{
	@Test
	public void createProjectTest()
	{
		//Step 1: Create the pre requisites--request Body
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Amarendra");
		jobj.put("projectName", "xylem");
		jobj.put("status", "completed");
		jobj.put("teamSize",25);

		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		
		//Step 2: perform the Action

		Response response = req.post("http://localhost:8084/addProject");

		//Step 3: Validate the response
		
		System.out.println(response.getContentType());
		System.out.println(response.asString());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());


	}
}
