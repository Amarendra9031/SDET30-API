package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured .*;

public class Oauth2_0 
{
	@Test
	public void oauthAuthentication()
	{
		Response resp = given()
				.formParam("client_id", "SDET30CoopsApi")
				.formParam("client_secret", "a6d00239a8ee34c5fdf41bed91bd5e8a")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "http://example.com")
				.formParam("code", "authorization_code")

				.when()
				.post("http://coop.apps.symfonycasts.com/token");

		//Capture the access token from the response of the above request

		String token = resp.jsonPath().get("access_token");
		System.out.println(token);

		//Create another request and use the token to access the APIs

		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 3106)

		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then().log().all();

	}
}
