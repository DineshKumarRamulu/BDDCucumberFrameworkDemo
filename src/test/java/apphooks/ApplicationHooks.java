package apphooks;

import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
    @Before(order=0,value="not@GoogleMapPlaceApi")
    public void getProperty()
    {
    	configReader = new ConfigReader();
    	prop = configReader.init_properties();
    }
    
    @Before(order=1,value="not@GoogleMapPlaceApi")
    public void launchBrowser() throws MalformedURLException
    {
    	String browsername = prop.getProperty("browser");
    	driverFactory = new DriverFactory();
    	driver = driverFactory.init_driver(browsername);
    }

    @After(order=0,value="not@GoogleMapPlaceApi")
    public void quitBrowser()
    {
    	driver.quit();
    }
    
    @After(order=1,value="not@GoogleMapPlaceApi")
    public void teardown(Scenario scenario)
    {
    	if(scenario.isFailed())
    	{
    		String screenshotName = scenario.getName().replaceAll("", "_");
    		byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    		scenario.attach(sourcepath, "image/png", screenshotName);
    	}
    }
    
}
