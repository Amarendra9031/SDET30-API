package ResponceValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import CommanLibrary.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured .*;

public class StaticResponceValidation 
{
	@Test
	public void staticResponce()
	{

		String expData="TY_PROJ_2403";
		JavaLibrary jLib = new JavaLibrary();
		ProjectLibrary pLib = new ProjectLibrary("Shashi", "Google", "Completed", 23);

		baseURI="http://localhost:8084/";

		Response resp = given()
				.body(pLib)
				.contentType(ContentType.JSON)

				.when()
				.post("addProject");


		String actData = resp.jsonPath().get("projectId");
		Assert.assertEquals(actData, expData);


		System.out.println("Data verified");

		resp.then().log().all();
	}
}
