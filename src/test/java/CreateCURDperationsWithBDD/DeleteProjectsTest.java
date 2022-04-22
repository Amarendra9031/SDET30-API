package CreateCURDperationsWithBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteProjectsTest 
{
	@Test
	public void deleteProjectsTest()
	{
		//create pre requisits
		baseURI="http://localhost:8084/";


		when()//step 2:perform action
		.delete("projects/TY_PROJ_2202")

		.then()//step 3: validate
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(204)
		.log().all();
	}
}
