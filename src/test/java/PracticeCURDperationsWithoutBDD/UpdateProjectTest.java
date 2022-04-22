package PracticeCURDperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest 
{
	@Test
	public void updateProjectTest()
	{
		//Step 1: Create the pre requisites--request Body
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Amarendra");
		jobj.put("projectName", "xylem");
		jobj.put("status", "completed");
		jobj.put("teamSize",40);

		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);

		//Step 2: perform the Action
		Response resp = RestAssured.put("http://localhost:8084/projects/TY_PROJ_2005");
		//Step 3:validate
		resp.then().log().all();
		int actstatus = resp.getStatusCode();
		Assert.assertEquals(actstatus,200);
	}
}
