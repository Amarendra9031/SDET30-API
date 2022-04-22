package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParametersTestForGIt
{
	@Test
	public void parametersforGit()
	{
		baseURI="https://api.github.com";
		given()
		.pathParam("username", "Amarendra9031")
		.queryParam("per_page", 30)
		.queryParam("page",1)

		.when()
		.get("/users/{username}/repos")
		.then()
		.log().all();
	}
}
