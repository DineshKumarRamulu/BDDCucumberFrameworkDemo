import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class SpecBuilderTest {

	
     public static void main(String[] args) {
		// TODO Auto-generated method stub
    	 
    	 AddPlace addPlace = new AddPlace();
 		
 		addPlace.setAccuracy(50);
 		addPlace.setName("Frontline house");
 		addPlace.setPhoneNumber("(+91) 983 893 3937");
 		addPlace.setAddress("29, side layout, cohen 09");
 		List<String> types = new ArrayList<String>();
 		types.add("shoe park");
 		types.add("shop");
 		addPlace.setTypes(types);
 		addPlace.setWebsite("http://google.com");
 		addPlace.setLanguage("French-IN");
 		Location l = new Location();
 		l.setLat(-38.383494);
 		l.setLng(33.427362);
 		addPlace.setLocation(l);
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setRelaxedHTTPSValidation()
		.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		ResponseSpecification res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		
		Response response = given().spec(req)
				.body(addPlace).when().post("/maps/api/place/add/json")
				.then().spec(res).extract().response();
		
		System.out.println(response.asString());
		
		System.out.println(response.getStatusCode());
		
		JsonPath path = response.jsonPath();
		
		String statusMessage = path.getString("status");
		
		System.out.println(statusMessage);
		
		
		
		

	}

}
