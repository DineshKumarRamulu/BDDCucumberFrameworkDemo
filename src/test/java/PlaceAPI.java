import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.AddPlace;
import pojo.Location;

public class PlaceAPI {
	


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
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		Response rs = given().relaxedHTTPSValidation().queryParam("key","qaclick123")
				.body(addPlace)
		.when().post("/maps/api/place/add/json")
		.then().statusCode(200).extract().response();
		
		String responseString = rs.asString();
		System.out.println(rs.getStatusCode());
		JsonPath js = rs.jsonPath();
		
		System.out.println(js.getString("status"));
		
		System.out.println(responseString);

	}

}
