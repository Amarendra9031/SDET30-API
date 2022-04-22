package ResponceValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured .*;

import java.util.List;

public class DynamicResponceValidation
{
	@Test
	public void dynamicResponce()
	{
		//pre requisties

		String expData="TY_PROJ_1447";
		baseURI="http://localhost:8084/";

		//action
		Response resp = when()
				.get("projects");
		//validation
		boolean flag=false;
		List<String>pIDs=resp.jsonPath().get("projectId");
		for(String projectId :pIDs)
		{
			if(projectId.equalsIgnoreCase(expData))
			{
				flag=true;

			}
		}
		Assert.assertTrue(flag);
		System.out.println("Data verified");

		resp.then().log().all();

	}
}
