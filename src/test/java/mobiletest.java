import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class mobiletest {
	
	

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver driver = null;
		// TODO Auto-generated method stub
		UiAutomator2Options options = new UiAutomator2Options()
		.setPlatformName("Android")
		.setPlatformVersion("14.0")
		.setAutomationName("UiAutomator2")
		.setDeviceName("emulator-5554")
		.noReset()
		.withBrowserName("Chrome");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
		driver.get("https://www.saucedemo.com/");
		
		
//		AndroidDriver driver = null;
//		// TODO Auto-generated method stub
//		UiAutomator2Options options = new UiAutomator2Options()
//		.setPlatformName("android")
//		.setPlatformVersion("10.0")
//		.setAutomationName("UiAutomator2")
//		.setDeviceName("Samsung Galaxy S20 Plus")
//		.noReset()
//		.withBrowserName("Chrome");
//		
//		String userName = "dineshkumar_btqCAe";
//		String accessKey ="CioByW1K72Ud1kD75kP2";
//		
//		driver = new AndroidDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com:443/"),options);
//		driver.get("https://www.saucedemo.com/");
	}

}
