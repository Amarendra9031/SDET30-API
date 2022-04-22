package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;

public class BearerToken 
{
	@Test
	public void bearertoken()
	{
		baseURI="https://api.github.com";
		JSONObject jObj = new JSONObject();
		jObj.put("name", "Sdet30-Restassured");

		given()       
		.auth()
		.oauth2("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")
		.body(jObj)
		.contentType(ContentType.JSON)

		.when()
		.post("/user/repos")
		.then().log().all();


	}

}
