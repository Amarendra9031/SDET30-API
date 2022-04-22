package CommanLibrary;

import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass 
{
	public DatabaseLibrary dLib = new DatabaseLibrary();
	public JavaLibrary jLib = new JavaLibrary();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();

	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		//Establish database connection
		dLib.connectToDB();
		System.out.println("=============db connection established============");

		//set base Uri and port
		baseURI = "http://localhost:8084/";

	}

	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();
	}

}
