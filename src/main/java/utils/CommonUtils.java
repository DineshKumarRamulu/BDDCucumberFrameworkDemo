package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class CommonUtils {
	
	public static final int IMPLICIT_WAIT_TIME =10;
	public static final int PAGE_LOAD_TIMEOUT =20;
	
	public static RequestSpecification reqSpec;
	ConfigReader config;
	Properties prop;
	
	public RequestSpecification requestSpecification() throws FileNotFoundException {
		
		if(reqSpec==null)
		{
		config = new ConfigReader();
		prop = new Properties();
		prop = config.init_properties();
		String baseUrl = prop.getProperty("baseUrl");
		PrintStream ps = new PrintStream(new FileOutputStream("logging.txt"));
		reqSpec = new RequestSpecBuilder().setBaseUri(baseUrl).setRelaxedHTTPSValidation()
		.addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(ps))
		.addFilter(ResponseLoggingFilter.logResponseTo(ps))
		.setContentType(ContentType.JSON).build();
		return reqSpec;
	    }
		return reqSpec;
		
}
	
	

}
