package factory;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.CommonUtils;

public class DriverFactory {
	
	public static WebDriver driver = null;
	
	
	public WebDriver init_driver(String browser) throws MalformedURLException
	{
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equals("mobileBrowser"))
		{
			UiAutomator2Options options = new UiAutomator2Options()
					.setPlatformName("Android")
					.setPlatformVersion("14.0")
					.setAutomationName("UiAutomator2")
					.setDeviceName("emulator-5554")
					.noReset()
					.withBrowserName("Chrome");
					
					driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
					
		}
		else if(browser.equals("mobileNativeApp"))
		{
			//AppiumDriver driver = null;
			UiAutomator2Options options = new UiAutomator2Options()
					.setPlatformName("Android")
					.setPlatformVersion("14.0")
					.setAutomationName("UiAutomator2")
					.setDeviceName("emulator-5554")
					.setAppPackage("com.saucelabs.mydemoapp.rn")
					.setAppActivity(".MainActivity")
					.setNoReset(true);
			
					
					driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
		}
		else
		{
			System.out.println("Please pass the correct browser value "+browser);
		}
		
		if(!browser.equals("mobileNativeApp"))
		{
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		}
		else
		{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		}
		
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
}
