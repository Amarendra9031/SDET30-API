package ResponceValidation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ResponseTimeCValidation 
{
	@Test
	public void responseTimeCValidation()
	{
		//pre requisites
		baseURI="http://localhost:8084/";
		//Action
		Response resp = when()
				.get("projects");
		//validation
		resp.then()
		.assertThat().time(Matchers.lessThan(800L),TimeUnit.MILLISECONDS)
		.log().all();
		long t = resp.time();
		System.out.println(t);

	}
}
