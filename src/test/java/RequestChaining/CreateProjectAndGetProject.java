package RequestChaining;

import org.testng.annotations.Test;

import CommanLibrary.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured .*;

public class CreateProjectAndGetProject 
{
	@Test
	public void requestchaining()
	{
		//Step 1: create a project using POJO
		JavaLibrary jLib=new JavaLibrary();
		ProjectLibrary pLib=new ProjectLibrary("Shashi", "Firefox "+jLib.getRandomNumber(), "Completed", 20);

		baseURI="http://localhost:8084/";


		Response resp = given()
				.body(pLib)
				.contentType(ContentType.JSON)
				.when()
				.post("addProject");

		//capture the project id

		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();

		//create a get request and pass proId as path parameter
		given()
		.pathParam("pid", proId)
		.when()
		.get("projects/{pid}")
		.then()
		.log().all();
	}
}
