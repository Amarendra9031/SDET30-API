package DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommanLibrary.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured .*;

public class CreateMultipleProjectWithDiffData 
{
	@Test(dataProvider = "getData")
	public void createProject(String createdBy,String projectName,String status,int teamSize )
	{
		//pre requisties
		JavaLibrary jLib=new JavaLibrary();
		ProjectLibrary pLib = new ProjectLibrary(createdBy, projectName+jLib.getRandomNumber(), status, teamSize);
		baseURI="http://localhost:8084/";

		given()
		.body(pLib)
		.contentType(ContentType.JSON)

		//Action
		.when()
		.post("addProject")

		//validation
		.then().log().all();

	}

	@DataProvider(name="getData")

	public Object[][] data()
	{
		Object[][] data=new Object[3][4];

		data[0][0]="Chaitra";
		data[0][1]="Dell";
		data[0][2]="Completed";
		data[0][3]=15;


		data[1][0]="Shashi";
		data[1][1]="Hp";
		data[1][2]="Completed";
		data[1][3]=25;


		data[2][0]="Amarendra";
		data[2][1]="Sony";
		data[2][2]="On going";
		data[2][3]=45;


		return data;

	}


}
