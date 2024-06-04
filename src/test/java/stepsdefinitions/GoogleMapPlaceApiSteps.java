package stepsdefinitions;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import testDataBuild.APITestData;
import utils.APIResources;
import utils.CommonUtils;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;


public class GoogleMapPlaceApiSteps {
	Response response;
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	APITestData testdata = new APITestData();
	CommonUtils utils = new CommonUtils();
	static JsonPath js;
	static String placeID;
	String responseResult;
	
	@Given("Load Place Payload with {string} {string} {string}")
	public void load_place_payload_with(String name, String language, String location) throws FileNotFoundException {
		 
		    
		    reqSpec = utils.requestSpecification();
		    reqSpec = given().spec(reqSpec)
					.body(testdata.addPlacePayLoad(name,language,location));
		    
		    
	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		
		APIResources resourceApi = APIResources.valueOf(resource);
		String resApi = resourceApi.getResource();
		resSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		if(method.equalsIgnoreCase("POST"))
		{
	    response = reqSpec.when().post(resApi);
		}
		else if(method.equalsIgnoreCase("DELETE"))
		{
		    response = reqSpec.when().delete(resApi);
		}
		else if (method.equalsIgnoreCase("GET"))
		{
			response = reqSpec.when().get(resApi);
		}
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(int statusCode) {
		response.then().spec(resSpec).extract().response();
	    assertEquals(response.getStatusCode(),statusCode);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		responseResult = response.asString();
		js = new JsonPath(responseResult);
		assertEquals(js.get(keyValue),expectedValue);
		placeID = js.getString("place_id");
		
		
	}
	
	@Given("User sends the placeid value in the Header")
	public void user_sends_the_placeid_value_in_the_header() throws FileNotFoundException {
		System.out.println(placeID);
		reqSpec = utils.requestSpecification();
		reqSpec = given().spec(reqSpec).queryParam("place_id", placeID);
		
	}
	
	@Then("reponse result name value should match with the request payload {string} value")
	public void reponse_result_name_value_should_match_with_the_request_payload_value(String expectedvalue) {
		responseResult = response.asString();
		js = new JsonPath(responseResult);
		assertEquals(js.get("name"),expectedvalue);
	}
	
	@Given("Load delete place payload")
	public void load_delete_place_payload() throws FileNotFoundException {
		reqSpec = utils.requestSpecification();
	    reqSpec = given().spec(reqSpec)
				.body(testdata.deletePlacePayload(placeID));

	}
				
		

	

}
