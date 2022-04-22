package PracticeCURDperationsWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest 
{
	@Test
	public void deleteProjectTest()
	{
		//Step 1: Create the pre requisites--request Body
		
		//Step 2: perform the Action
		
		   Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_2002");
		   
		//Step 3: Validate the response
		   
		   resp.then().log().all();
			int actstatus = resp.getStatusCode();
			Assert.assertEquals(actstatus,204);

	}
}
