package apiTests;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.google.common.io.Files;
import com.google.gson.JsonParser;

import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PetStoreAPI_Tests {
	
	
	/*
	 * Scenario: As a user, I should be able to perform POST request to add new pet to store 
	 * Given I have the POST request URL and valid request body 
	 * When I perform POST request to URL with request body 
	 * Then Response status code should be 200 
	 * And content type is application.json 
	 * And response body match the request body
	 */
	
	String requestURL;
	File requestBody;
	Response response;
	
  @Test
  public void createAPet() {
	  requestURL = "https://petstore.swagger.io/v2/pet";
	  requestBody = new File("./src/test/resources/jsonFiles/addAPet.json");
	  
	  response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(requestBody)
	  .when().post(requestURL);
	  
	  response.then().assertThat().contentType("application/json")
	  .and().assertThat().statusCode(200);
	  
  }
}
