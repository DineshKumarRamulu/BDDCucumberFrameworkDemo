package testDataBuild;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class APITestData {
	
	public AddPlace addPlacePayLoad(String name, String language, String address)
	{
		AddPlace addPlace = new AddPlace();
 		addPlace.setAccuracy(50);
 		addPlace.setName(name);
 		addPlace.setPhoneNumber("(+91) 983 893 3937");
 		addPlace.setAddress(address);
 		List<String> types = new ArrayList<String>();
 		types.add("shoe park");
 		types.add("shop");
 		addPlace.setTypes(types);
 		addPlace.setWebsite("http://google.com");
 		addPlace.setLanguage(language);
 		Location l = new Location();
 		l.setLat(-38.383494);
 		l.setLng(33.427362);
 		addPlace.setLocation(l);
 		
 		return addPlace;
	}
	
	public HashMap<String, String> deletePlacePayload(String placeID)
	{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("place_id", placeID);
		return map;
	}

}
